package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.mappers.CellBlockMapper;
import com.realdolmen.erkoja.boxed.services.CellBlockService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class CellBlockFacade implements Serializable{

    public CellBlockFacade() {
    }
    
    @Inject
    private CellBlockService cellBlockService;
//    @Inject
//    private CellBlockMapper cellBlockMapper;
    
//    public List<CellBlockDto> findAll(){
//        List<CellBlock> cellBlocks = cellBlockService.findAll();
//        List<CellBlockDto> cellBlockDtos = new ArrayList<>();
//        for(CellBlock cb : cellBlocks){
//            cellBlockDtos.add(cellBlockMapper.apply(cb));
//        }
//        return cellBlockDtos;
//    }
    
      public List<CellBlockDto> findAllCellBlocks() {
        List<CellBlock> cellBlocks = cellBlockService.findAll();
        return cellBlocks.stream()
                .map(cellBlock -> new CellBlockMapper().apply(cellBlock))
                .sorted((c1, c2) -> c1.getCellBlockId().compareTo(c2.getCellBlockId()))
                .collect(Collectors.toList());
    } 
}
