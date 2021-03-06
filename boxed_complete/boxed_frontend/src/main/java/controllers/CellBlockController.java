package controllers;

import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.DayDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.exceptions.CellFullException;
import com.realdolmen.erkoja.boxed.facades.CellFacade;
import com.realdolmen.erkoja.boxed.facades.CrimeFacade;
import com.realdolmen.erkoja.boxed.facades.DayFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonerFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CellBlockController implements Serializable {
    
    private String cellBlockId;
    private List<CellDto> cellsA;
    private List<CellDto> cellsB;
    private List<CellDto> cellsC;
    private List<CellDto> cellsD;
    private CellDto currentCell;
    private PrisonerDto currentPrisoner;
    private String prisonerName;
    private List<PrisonerDto> prisonerList;
    private List<CellBlockDto> cellBlocks;
    private List<CrimeDto> crimes;
    private List<String> crimeNames;
    private String currentCrimeName;
    private List<CellDto> allCells;
    private DayDto currentDay;
    private List<CrimeDto> prisonerCrimes;

    @Inject
    private CellBlockFacade cellBlockFacade;

    @Inject
    private CellFacade cellFacade;

    @Inject
    private CrimeFacade crimeFacade;

    @Inject
    private PrisonFacade prisonFacade;

    @Inject
    private DayFacade dayFacade;
    
    @Inject
    private PrisonerFacade prisonerFacade;

    @PostConstruct
    public void init() {
        prisonFacade.generateDays();
        cellBlocks = cellBlockFacade.findAllCellBlocks();
        allCells = cellFacade.findAllCells();

        crimes = crimeFacade.findAll();
        crimeNames = new ArrayList<>();

        for (CrimeDto c : crimes) {
            String name = c.getName();
            crimeNames.add(name);
        }

        cellsA = cellBlocks.get(0).getCells();
        cellsB = cellBlocks.get(1).getCells();
        cellsC = cellBlocks.get(2).getCells();
        cellsD = cellBlocks.get(3).getCells();

    }

    public String createStyle(CellDto c) {
        if (c.getPrisonerList().size() < c.getSize()) {
            return "success";
        } else {
            return "danger";
        }
    }
    
    
    public String spaceLeft(CellDto c){
        if(c != null){
        int left = c.getSize();
        if(c.getPrisonerList() != null){
        int leftAfter = c.getSize()-c.getPrisonerList().size();
        if(leftAfter == 0){
        return "<div style='width: 100%; height: 100%; border: solid black 1px;background-color: #C9302C'>"+String.valueOf(leftAfter)+"</div>";
        }
        return "<div style='width: 100%; height: 100%; border: solid black 1px;background-color: #449D44'>"+String.valueOf(leftAfter)+"</div>";
        }
        return "<div style='width: 100%; height: 100%; border: solid black 1px;background-color: #449D44'>"+String.valueOf(left)+"</div>";
        }
        return null;
    }

    public void addPrisoner(String prisonerName, Integer cellId, String currentCrimeName) throws CellFullException{
        try{
        prisonerCrimes = new ArrayList<>();
        currentPrisoner = new PrisonerDto();
        Integer releaseDate = dayFacade.getCurrentDay().getDayNr();
        for (CrimeDto c : crimes) {
            if (c.getName() == currentCrimeName) {
                prisonerCrimes.add(c);
                releaseDate = releaseDate + c.getPunishment();
            }
        }
        currentPrisoner.setId(null);
        currentPrisoner.setName(prisonerName);
        currentPrisoner.setReleaseDate(releaseDate);
        currentPrisoner.setCrimes(prisonerCrimes);
        CellDto cell = cellFacade.findCellById(cellId);
        prisonerFacade.addPrisoner(currentPrisoner, cell);
        CellDto cellAfterSave = cellFacade.findCellById(cellId);
        setCurrentCell(cellAfterSave);
        }catch(CellFullException c){
            spaceLeft(cellFacade.findCellById(cellId));
        }
        setCurrentCrimeName(null);
        setPrisonerName(null);
    }


    public void deletePrisoner(PrisonerDto currentPrisoner, CellDto currentCell) {
        if(currentCell.getPrisonerList() != null && currentCell.getPrisonerList().contains(currentPrisoner)){
            prisonerFacade.deletePrisoner(currentPrisoner, currentCell);
            CellDto cellAfterSave = cellFacade.findCellById(currentCell.getCellId());
            setCurrentCell(cellAfterSave);
        }
    }

    public DayDto getCurrentDay() {
        currentDay = dayFacade.getCurrentDay();
        return currentDay;
    }

    public void setCurrentDay(DayDto currentDay) {
        this.currentDay = currentDay;
    }

    public String getCellBlockId() {
        return cellBlockId;
    }

    public void setCellBlockId(String cellBlockId) {
        this.cellBlockId = cellBlockId;
    }

    public List<CellDto> getCellsA() {
        return cellsA;
    }

    public void setCellsA(List<CellDto> cellsA) {
        this.cellsA = cellsA;
    }

    public List<CellDto> getCellsB() {
        return cellsB;
    }

    public void setCellsB(List<CellDto> cellsB) {
        this.cellsB = cellsB;
    }

    public List<CellDto> getCellsC() {
        return cellsC;
    }

    public List<CrimeDto> getPrisonerCrimes() {
        return prisonerCrimes;
    }

    public void setPrisonerCrimes(List<CrimeDto> prisonerCrimes) {
        this.prisonerCrimes = prisonerCrimes;
    }

    public void setCellsC(List<CellDto> cellsC) {
        this.cellsC = cellsC;
    }

    public List<CellDto> getCellsD() {
        return cellsD;
    }

    public void setCellsD(List<CellDto> cellsD) {
        this.cellsD = cellsD;
    }

    public CellDto getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(CellDto currentCell) {
        this.currentCell = cellFacade.findCellById(currentCell.getCellId());
    }

    public List<PrisonerDto> getPrisonerList() {
        return prisonerList;
    }

    public void setPrisonerList(List<PrisonerDto> prisonerList) {
        this.prisonerList = prisonerList;
    }

    public List<CellBlockDto> getCellBlocks() {
        return cellBlocks;
    }

    public void setCellBlocks(List<CellBlockDto> cellBlocks) {
        this.cellBlocks = cellBlocks;
    }

    public CellBlockFacade getCellBlockFacade() {
        return cellBlockFacade;
    }

    public void setCellBlockFacade(CellBlockFacade cellBlockFacade) {
        this.cellBlockFacade = cellBlockFacade;
    }

    public PrisonerDto getCurrentPrisoner() {
        return currentPrisoner;
    }

    public void setCurrentPrisoner(PrisonerDto currentPrisoner) {
        this.currentPrisoner = currentPrisoner;
    }

    public CellFacade getCellFacade() {
        return cellFacade;
    }

    public void setCellFacade(CellFacade cellFacade) {
        this.cellFacade = cellFacade;
    }

    public List<CrimeDto> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<CrimeDto> crimes) {
        this.crimes = crimes;
    }

    public CrimeFacade getCrimeFacade() {
        return crimeFacade;
    }

    public void setCrimeFacade(CrimeFacade crimeFacade) {
        this.crimeFacade = crimeFacade;
    }

    public List<String> getCrimeNames() {
        return crimeNames;
    }

    public String getCurrentCrimeName() {
        return currentCrimeName;
    }

    public void setCurrentCrimeName(String currentCrimeName) {
        this.currentCrimeName = currentCrimeName;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public List<CellDto> getAllCells() {
        return allCells;
    }

    public void setAllCells(List<CellDto> allCells) {
        this.allCells = allCells;
    }
}
