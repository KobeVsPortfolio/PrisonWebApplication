/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.dtos;


import java.util.List;

/**
 *
 * @author JVDBG19
 */
public class CellDto {
    private Integer cellId;
    private String cellNr;
    private CellBlockDto cellBlock;
    private Integer size;
    private boolean isolationCell;
    private List<PrisonerDto> prisonerList;

    public CellDto(Integer cellId,String cellNr, Integer size, boolean isolationCell) {
        this.cellId = cellId;
        this.cellNr = cellNr;
        this.size = size;
        this.isolationCell = isolationCell;
    }

    public String getCellNr() {
        return cellNr;
    }

    public void setCellNr(String cellNr) {
        this.cellNr = cellNr;
    }

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    public CellBlockDto getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlockDto cellBlock) {
        this.cellBlock = cellBlock;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isIsolationCell() {
        return isolationCell;
    }

    public void setIsolationCell(boolean isolationCell) {
        this.isolationCell = isolationCell;
    }

    public List<PrisonerDto> getPrisonerList() {
        return prisonerList;
    }

    public void setPrisonerList(List<PrisonerDto> prisonerList) {
        this.prisonerList = prisonerList;
    }

    
}
