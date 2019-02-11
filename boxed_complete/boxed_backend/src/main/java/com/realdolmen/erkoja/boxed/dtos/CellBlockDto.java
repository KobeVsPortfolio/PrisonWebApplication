
package com.realdolmen.erkoja.boxed.dtos;


import java.util.List;

public class CellBlockDto {
    private String cellBlockId;
    private List<CellDto> cells;
    private List<GuardDto> guards;

    public CellBlockDto(String cellBlockId) {
        this.cellBlockId = cellBlockId;
    }

    public String getCellBlockId() {
        return cellBlockId;
    }

    public void setCellBlockId(String cellBlockId) {
        this.cellBlockId = cellBlockId;
    }

    public List<CellDto> getCells() {
        return cells;
    }

    public void setCells(List<CellDto> cells) {
        this.cells = cells;
    }

    public List<GuardDto> getGuards() {
        return guards;
    }

    public void setGuards(List<GuardDto> guards) {
        this.guards = guards;
    }

}