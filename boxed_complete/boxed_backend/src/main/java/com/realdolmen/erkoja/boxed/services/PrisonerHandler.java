package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Persistence;

public class PrisonerHandler implements Serializable{
    
    @Inject
    private PrisonerRepository prisonerRepository;
    
    @Inject
    private CellRepository cellRepository;
    
    @Inject
    private CellService cellService;
    
    @Inject
    private DayService dayService;
    
    @Inject
    private PrisonFacade prisonFacade;
    
    private Day currentDay;

    public PrisonerHandler() {
    }
    
    public void handlePrisoners() {
        releasePrisoners();
        moveOutOfIsolation();
    }

    public void movePrisoners(Cell out, Cell in, Prisoner p) {
        cellService.removePrisoner(p, out);
        cellService.addPrisoner(p, in);
        p.setCell(in);
        prisonerRepository.update(p);
    }

    public void releasePrisoners() {
        currentDay = dayService.getCurrentDay();
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
        prisoner.setIsolationDuration(dayService.getCurrentDay().getDayNr() + 10);
        prisoner.setIsolated(true);
        addToReleaseDate(60, prisoner);
        movePrisoners(originCell, isolationCell, prisoner);
    }
    
    void moveOutOfIsolation(){
        currentDay = dayService.getCurrentDay();
        Integer day = currentDay.getDayNr();
        List<Prisoner> prisonersInIsolation = prisonerRepository.findPrisonersInIsolation(day);
        for (Prisoner p : prisonersInIsolation) {
            Cell out = p.getCell();
            Cell in = cellRepository.findEmptyCellsByCellBlock(p.getCell().getCellBlock().getCellBlockId());
            p.setIsolated(false);
            p.setIsolationDuration(0);
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
    
    public void finishJobs(){
        currentDay = dayService.getCurrentDay();
        Integer day = currentDay.getDayNr();
        List<Prisoner> prisonersWithFinishedJob = prisonerRepository.findPrisonersWithFinishedJob(day);
        for (Prisoner p : prisonersWithFinishedJob) {
        p.setJob(null);
        p.setJobDuration(0);
        subtractReleaseDate(60, p);
        }
    }

        public void giveJob(Job job, Prisoner prisoner){
        prisoner.setJob(job);
        prisoner.setJobDuration(dayService.getCurrentDay().getDayNr() + job.getDuration());
        prisonerRepository.update(prisoner);
    }

}
