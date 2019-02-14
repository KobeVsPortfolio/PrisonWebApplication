package com.realdolmen.erkoja.boxed.domain;

import javax.persistence.*;

@Entity
@Table(name = "Guard")
public class Guard extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cellBlock")
    private CellBlock cellBlock;
    
    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Guard() {
    }

    public Guard(CellBlock cellBlock, Grade grade) {
        this.cellBlock = cellBlock;
        this.grade = grade;
    }
    public CellBlock getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlock cellBlock) {
        this.cellBlock = cellBlock;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    } 
}
