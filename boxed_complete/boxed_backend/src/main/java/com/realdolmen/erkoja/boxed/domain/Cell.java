package com.realdolmen.erkoja.boxed.domain;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Cell")
@NamedQueries({
@NamedQuery(name = Cell.FIND_CELLS_BY_CELLBLOCK, query = "select c from Cell c where c.cellBlock.cellBlockId = :cellBlock AND c.isolationCell = false"),
@NamedQuery(name = Cell.FIND_ISOLATION_BY_CELLBLOCK, query = "select c from Cell c where c.isolationCell = true AND c.cellBlock.cellBlockId = :cellBlock")})
public class Cell {
    public static final String FIND_CELLS_BY_CELLBLOCK = "FindCellsByCellBlock";
    public static final String FIND_ISOLATION_BY_CELLBLOCK = "FindIsolationByCellBlock";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cellId;
    
    @Column(nullable = false)
    private String cellNr;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    @JoinColumn(name = "cellBlock")
    private CellBlock cellBlock;
    
    @Column(nullable = false)
    private Integer size;
    
    private boolean isolationCell;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cell")
    private List<Prisoner> prisonerList;

    public Cell() {
    }

    public Cell(String cellNr, Integer size, CellBlock cellBlock, boolean isolationCell) {
        this.cellNr = cellNr;
        this.size = size;
        this.cellBlock = cellBlock;
        this.isolationCell = isolationCell;
    }
    
      public Cell(Integer cellId, String cellNr, Integer size, boolean isolationCell) {
        this.cellId = cellId;
        this.cellNr = cellNr;
        this.size = size;
        this.isolationCell = isolationCell;
    }
    
    public void removePrisoner(Prisoner prisoner){
        if(this.prisonerList.contains(prisoner)){
            prisonerList.remove(prisoner);
        } else {
            System.out.println("cell " + this.cellNr + " does not contain prisoner ");
        }
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
