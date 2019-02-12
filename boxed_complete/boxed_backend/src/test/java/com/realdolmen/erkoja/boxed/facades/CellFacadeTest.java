
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.services.CellService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellFacadeTest {
    @Mock
    private CellService cellService;

    @InjectMocks
    private CellFacade cellFacade;
    
    @Test
    public void FindAllCellandAddCellTestDto(){
        List<Cell> cells = new ArrayList<>();
        Cell cell = new Cell();
        cell.setCellNr("A15");
        cells.add(cell);
        List<CellDto> result = cellFacade.findAllCells();
        when(cellService.findAllCells()).thenReturn(cells);
        assertNotNull(result);
               


    }
    
    
   
    
}
