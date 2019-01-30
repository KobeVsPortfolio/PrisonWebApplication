package domain;

import java.util.List;
import javax.persistence.*;

public class CellBlock {
    
    private String cellBlockId;
    
    private List<Cell> cells;
    
    private List<Guard> guards;
    
    public CellBlock() {
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public String getCellBlockId() {
        return cellBlockId;
    }

    public void setCellBlockId(String cellBlockId) {
        this.cellBlockId = cellBlockId;
    }

    public List<Guard> getGuards() {
        return guards;
    }

    public void setGuards(List<Guard> guards) {
        this.guards = guards;
    }
    
    
    
}
