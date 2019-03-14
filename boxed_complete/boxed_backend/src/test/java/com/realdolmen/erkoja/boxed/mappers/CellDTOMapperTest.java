package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellDTOMapperTest {

    public CellDTOMapperTest() {
    }

    @Test
    public void CellDtoEqualsCellTest() {
        CellDto dto = new CellDto();
        dto.setCellId(15);
        dto.setSize(2);
        dto.setCellNr("A15");

        CellDTOMapper cdm = new CellDTOMapper();
        Cell cell = cdm.apply(dto);
        assertEquals(dto.getCellId(), cell.getCellId());
        assertEquals(dto.getSize(), cell.getSize());
        assertEquals(dto.getCellNr(), cell.getCellNr());
    }

}
