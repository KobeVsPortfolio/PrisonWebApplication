
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellMapperTest {
    
    @Test
    public void CellDtoEqualsCellTest(){
        Cell cell = new Cell();
        cell.setCellId(15);
        cell.setSize(2);
        cell.setCellNr("A15");
        List<Prisoner> prisoners = new ArrayList<>();
        Prisoner prisoner = new Prisoner();
        prisoner.setId(5);
        prisoners.add(prisoner);
        cell.setPrisonerList(prisoners);
        CellBlock cellB = new CellBlock();
        cellB.setCellBlockId("A");
        cell.setCellBlock(cellB);
        CellMapper cellM = new CellMapper();
        CellDto cellDto = cellM.apply(cell);
        assertEquals(cellDto.getCellBlock().getCellBlockId(), cell.getCellBlock().getCellBlockId());
        assertEquals(cellDto.getCellId(),cell.getCellId());
        assertEquals(cellDto.getSize(),cell.getSize());
        assertEquals(cellDto.getCellNr(),cell.getCellNr());
        assertEquals(cellDto.getPrisonerList().get(0).getId(),cell.getPrisonerList().get(0).getId());
    }
    
    @Test
    public void CellDtoCellBlockEqualsCellTest(){
        Cell cell = new Cell();
        CellBlock cellBlock = new CellBlock();
        cellBlock.setCellBlockId("A");
        cell.setCellBlock(cellBlock);
        List<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cellBlock.setCells(cells);
        CellMapper cellM = new CellMapper();
        CellDto cellDto = cellM.apply(cell);
        assertEquals(cellDto.getCellBlock().getCellBlockId(), cell.getCellBlock().getCellBlockId());
    }
}
