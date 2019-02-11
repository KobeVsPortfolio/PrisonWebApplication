package controllers;

import domain.Cell;
import domain.Prisoner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CellBlockController implements Serializable {

    
    private String cellBlockId;
    private List<Cell> cellsA;
    private List<Cell> cellsB;
    private List<Cell> cellsC;
    private List<Cell> cellsD;
    private Cell currentCell;
    private Prisoner prisoner;
    private List<Prisoner> prisonerList;
    
    @PostConstruct
    public void init() {
        cellsA = new ArrayList<>();
        cellsB = new ArrayList<>();
        cellsC = new ArrayList<>();
        cellsD = new ArrayList<>();
        
        
        
        for(int i = 1; i<31; i++){
            Cell cell = new Cell();
            prisoner = new Prisoner();
            prisonerList = new ArrayList<>();
            prisoner.setName("Bob " + i);
            prisonerList.add(prisoner);
            prisonerList.add(prisoner);
            cell.setPrisonerList(prisonerList);
            cell.setCellNr("A"+i);
            cellsA.add(cell);
        }
        
        for(int i = 31; i<61; i++){
            Cell cell = new Cell();
            prisonerList = new ArrayList<>();
            cell.setPrisonerList(prisonerList);
            cell.setCellNr("A" + i);
            cellsA.add(cell);
        }

        for (int i = 1; i < 61; i++) {
            Cell cell = new Cell();
            cell.setCellNr("B" + i);
            prisoner = new Prisoner();
            prisonerList = new ArrayList<>();
            prisoner.setName("Frank " + i);
            prisonerList.add(prisoner);
            cell.setPrisonerList(prisonerList);
            cell.setCellNr("B"+i);
            cellsB.add(cell);
        }

        for (int i = 1; i < 61; i++) {
            Cell cell = new Cell();
            prisonerList = new ArrayList<>();
            cell.setPrisonerList(prisonerList);
            cell.setCellNr("C" + i);
            cellsC.add(cell);
        }

        for (int i = 1; i < 61; i++) {
            Cell cell = new Cell();
            prisoner = new Prisoner();
            prisonerList = new ArrayList<>();
            prisoner.setName("John " + i);
            prisonerList.add(prisoner);
            cell.setPrisonerList(prisonerList);
            cell.setCellNr("D"+i);
            cellsD.add(cell);
        }
    }

    public String createStyle(Cell c) {
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

    public List<Cell> getCellsA() {
        return cellsA;
    }

    public void setCellsA(List<Cell> cellsA) {
        this.cellsA = cellsA;
    }

    public List<Cell> getCellsB() {
        return cellsB;
    }

    public void setCellsB(List<Cell> cellsB) {
        this.cellsB = cellsB;
    }

    public List<Cell> getCellsC() {
        return cellsC;
    }

    public void setCellsC(List<Cell> cellsC) {
        this.cellsC = cellsC;
    }

    public List<Cell> getCellsD() {
        return cellsD;
    }

    public void setCellsD(List<Cell> cellsD) {
        this.cellsD = cellsD;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public List<Prisoner> getPrisonerList() {
        return prisonerList;
    }

    public void setPrisonerList(List<Prisoner> prisonerList) {
        this.prisonerList = prisonerList;
    }
}
