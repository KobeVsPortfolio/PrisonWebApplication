package controllers;

import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.DayDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.facades.CellFacade;
import com.realdolmen.erkoja.boxed.facades.CrimeFacade;
import com.realdolmen.erkoja.boxed.facades.DayFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
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
    
    @PostConstruct
    public void init() {
        prisonFacade.generateDays();
        cellBlocks = cellBlockFacade.findAllCellBlocks();
        allCells = cellFacade.findAllCells();
        
        crimes = crimeFacade.findAll();
        crimeNames = new ArrayList<>();
        
        for(CrimeDto c : crimes){
            String name = c.getName();
            crimeNames.add(name);
        }
        
        cellsA = cellBlocks.get(0).getCells();
        cellsB = cellBlocks.get(1).getCells();
        cellsC = cellBlocks.get(2).getCells();
        cellsD = cellBlocks.get(3).getCells();
        
    }

    public String createStyle(CellDto c) {
        if (c.getPrisonerList().size() != 0) {
            return "background-color: #D9534F;";
        } else {
            return "background-color: #5CB85C;";
        }
    }
    
    public void addPrisoner(String prisonerName, CellDto currentCell, String currentCrimeName){ 
        List<CrimeDto> prisonerCrimes = new ArrayList<>();
        Integer releaseDate = 0;
        for(CrimeDto c : crimes){
            if(c.getName() == currentCrimeName){
                prisonerCrimes.add(c);
                releaseDate = c.getPunishment();
            }
        }
          currentPrisoner = new PrisonerDto(null, prisonerName, false, null, releaseDate, null);
          currentPrisoner.setCrimes(prisonerCrimes);
        
        for(CellDto cell : allCells){
            if(cell.getCellNr() == currentCell.getCellNr()){
                currentCell = cell;
            }
        }
        cellFacade.addPrisoner(currentPrisoner, currentCell);
    }
    
    public void showPrisonerInfo(String prisonerName, String cellNr, String currentCrimeName){
        currentPrisoner = new PrisonerDto();
        currentPrisoner.setName(prisonerName);
        CellDto c = new CellDto();
        c.setCellNr(cellNr);
        currentPrisoner.setCell(c);
        List<CrimeDto> prisonerCrimes = new ArrayList<>();
        Integer releaseDate = 0;
        for(CrimeDto cDto : crimes){
            if(cDto.getName() == currentCrimeName){
                prisonerCrimes.add(cDto);
                releaseDate = cDto.getPunishment();
            }
        }
        currentPrisoner.setReleaseDate(releaseDate);
        currentPrisoner.setCrimes(prisonerCrimes);
        }
    
    public void deletePrisonerInfo(){
        currentPrisoner = new PrisonerDto();
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
        this.currentCell = currentCell;
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
