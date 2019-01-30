package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.JobRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.List;
import javax.persistence.Persistence;

public class PrisonerHandler {

    private PrisonerRepository prisonerRepository;
    private CellRepository cellRepository;
    private CellService cellService;
    private DayService dayService;
    private Day currentDay;

    private JobRepository jobRepository;

    private Integer currentDayNr;


    public PrisonerHandler() {
        prisonerRepository = new PrisonerRepository(Persistence.createEntityManagerFactory("BoxedPersistenceUnit").createEntityManager());
        cellRepository = new CellRepository(Persistence.createEntityManagerFactory("BoxedPersistenceUnit").createEntityManager());
        
    }

    public PrisonerHandler(PrisonerRepository prisonerRepository, CellRepository cellRepository) {
        this.prisonerRepository = prisonerRepository;
        this.cellRepository = cellRepository;
    }

    public void handlePrisoners() {
        dayService = new DayService();
        currentDay = dayService.getCurrentDay();
        releasePrisoners();
        moveOutOfIsolation();
    }

    public void movePrisoners(Cell out, Cell in, Prisoner p) {
        cellService = new CellService();
        cellService.removePrisoner(p, out);
        cellService.addPrisoner(p, in);
        p.setCell(in);
        prisonerRepository.update(p);
    }

    public void releasePrisoners() {
        Integer day = currentDay.getDayNr();
        List<Prisoner> prisonersToRelease = prisonerRepository.findPrisonersToRelease(day);
        for (Prisoner p : prisonersToRelease) {
            prisonerRepository.delete(p.getId());
        }
    }

    void sendToIsolation(Prisoner prisoner) {
        Cell originCell = prisoner.getCell();
        CellBlock prisonersCellBlock = originCell.getCellBlock();
        String cbId = prisonersCellBlock.getCellBlockId();
        Cell isolationCell = cellRepository.findEmptyIsolationCellByCellBlock(cbId);
        prisoner.setIsolated(dayService.getCurrentDay().getDayNr() + 10);
        addToReleaseDate(60, prisoner);
        movePrisoners(originCell, isolationCell, prisoner);
    }
    
    void moveOutOfIsolation(){
        Integer day = currentDay.getDayNr();
        List<Prisoner> prisonersInIsolation = prisonerRepository.findPrisonersInIsolation(day);
        for (Prisoner p : prisonersInIsolation) {
            Cell out = p.getCell();
            Cell in = cellRepository.findEmptyCellsByCellBlock(p.getCell().getCellBlock().getCellBlockId());
            p.setIsolated(null);
            // null op Integer????? Wat doen met status prisoner niet meer in isolatiecell zit?
            movePrisoners(out, in, p);      
        }
    }
    
    public void subtractReleaseDate(Integer amount, Prisoner p){
        Integer startingReleaseDate = p.getReleaseDate();
        p.setReleaseDate(startingReleaseDate-amount);
        prisonerRepository.update(p);
    }
    
    public void addToReleaseDate(Integer amount, Prisoner p){
        Integer startingReleaseDate = p.getReleaseDate();
        p.setReleaseDate(startingReleaseDate+amount);
        prisonerRepository.update(p);
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }
    
    public void finishJobs(Job job, Prisoner prisoner){
        Integer day = currentDay.getDayNr();
        List<Prisoner> prisonersWithFinishedJob = prisonerRepository.findPrisonersWithFinishedJob(day);
        for (Prisoner p : prisonersWithFinishedJob) {
        subtractReleaseDate(60, p);        }
    }

        public void giveJob(Job job, Prisoner prisoner){
        prisoner.setJob(job);
        prisoner.setJobDuration(dayService.getCurrentDay().getDayNr() + job.getDuration());
        jobRepository.update(job);
    }

}
