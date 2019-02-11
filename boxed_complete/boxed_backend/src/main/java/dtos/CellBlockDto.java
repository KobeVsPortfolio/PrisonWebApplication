/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;


import java.util.List;

/**
 *
 * @author JVDBG19
 */
public class CellBlockDto {
    private String cellBlockId;
    private List<CellDto> cells;
    private List<GuardDto> guards;

    public CellBlockDto(String cellBlockId, List<CellDto> cells, List<GuardDto> guards) {
        this.cellBlockId = cellBlockId;
        this.cells = cells;
        this.guards = guards;
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