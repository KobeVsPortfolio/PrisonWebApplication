
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.mappers.CellBlockMapper;
import com.realdolmen.erkoja.boxed.services.CellBlockService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellBlockFacadeTest {

    @Mock
    private CellBlockService cellBlockService;
    @Mock
    private CellBlockMapper cellBlockMapper;
    @InjectMocks
    private CellBlockFacade cellBlockFacade;
    
    @Test
    public void FindAllCelBlockandAddCellBlockTestDto(){
       List<CellBlock> cellBlocks = new ArrayList<>();
       CellBlock cellBlock = new CellBlock();
       cellBlock.setCellBlockId("A");
       CellBlock cellBlock2 = new CellBlock();
       cellBlock2.setCellBlockId("B");
       cellBlocks.add(cellBlock);
       cellBlocks.add(cellBlock2);
       List<CellBlockDto> cellBlockDtos = new ArrayList<>();
       CellBlockDto cbDto = new CellBlockDto();
       cellBlockDtos.add(cbDto);
       when(cellBlockService.findAll()).thenReturn(cellBlocks);
       when(cellBlockMapper.apply(cellBlocks.get(0))).thenReturn(cellBlockDtos.get(0));
       List<CellBlockDto> result = cellBlockFacade.findAll();
       verify(cellBlockService, times(1)).findAll();
       verify(cellBlockMapper, times(1)).apply(cellBlocks.get(0));
       assertNotNull(result);
    }
        
        
    }
    

