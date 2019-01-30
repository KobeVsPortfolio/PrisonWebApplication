package com.realdolmen.erkoja.boxed.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "CellBlock")
public class CellBlock {
    
    @Id
    @Column(nullable = false)
    private String cellBlockId;
    
    @OneToMany(mappedBy = "cellBlock")
    private List<Cell> cells;
    
    @OneToMany(mappedBy = "cellBlock")
    private List<Guard> guards;
    
    public CellBlock() {
    }

    public CellBlock(List<Cell> cells, String cellBlockId) {
        this.cells = cells;
        this.cellBlockId = cellBlockId;
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