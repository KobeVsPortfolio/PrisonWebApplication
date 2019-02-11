
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellBlockMapperTest {
    
    @Test
    public void CellBlockDtoEqualsCellBlockTest(){
    CellBlock cellBlock = new CellBlock();
    cellBlock.setCellBlockId("A");
    List<Guard> guards = new ArrayList<>();
    Guard guard = new Guard();
    guard.setName("John");
    guards.add(guard);
    List<Cell> cells = new ArrayList<>();
    Cell cell = new Cell();
    cell.setCellId(10);
    cells.add(cell);
    cellBlock.setGuards(guards);
    cellBlock.setCells(cells);
    CellBlockMapper cellBlockM = new CellBlockMapper();
    CellBlockDto cellBlockDto = cellBlockM.apply(cellBlock);
    assertEquals(cellBlockDto.getCellBlockId(),cellBlock.getCellBlockId());
    assertEquals(cellBlockDto.getGuards().get(0).getName(),cellBlock.getGuards().get(0).getName());
    assertEquals(cellBlockDto.getCells().get(0).getCellId(),cellBlock.getCells().get(0).getCellId());
    }
    
}
