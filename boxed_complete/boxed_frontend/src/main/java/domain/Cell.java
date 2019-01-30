package domain;

import java.util.List;
import javax.persistence.*;

public class Cell {

    private Integer cellId;
    
    @Column(nullable = false)
    private String cellNr;

    private CellBlock cellBlock;
    
    private Integer size;
    
    private boolean isolationCell;
    
    private List<Prisoner> prisonerList;

    public Cell() {
    }
    
    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }
    
    public String getCellNr() {
        return cellNr;
    }

    public void setCellNr(String cellNr) {
        this.cellNr = cellNr;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public CellBlock getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlock cellBlock) {
        this.cellBlock = cellBlock;
    }
    
    public boolean isIsolationCell() {
        return isolationCell;
    }

    public void setIsolationCell(boolean isolationCell) {
        this.isolationCell = isolationCell;
    }

    public List<Prisoner> getPrisonerList() {
        return prisonerList;
    }

    public void setPrisonerList(List<Prisoner> prisonerList) {
        this.prisonerList = prisonerList;
    }
}
