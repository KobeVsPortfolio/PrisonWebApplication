package controllers;

import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.io.Serializable;
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
    private PrisonerDto prisoner;
    private List<PrisonerDto> prisonerList;
    private List<CellBlockDto> cellBlocks; 
    
    @Inject
    private CellBlockFacade cellBlockFacade;
    
    @PostConstruct
    public void init() {
        
        cellBlocks = cellBlockFacade.findAllCellBlocks();
        
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

    public PrisonerDto getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(PrisonerDto prisoner) {
        this.prisoner = prisoner;
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
    
    
    
}
