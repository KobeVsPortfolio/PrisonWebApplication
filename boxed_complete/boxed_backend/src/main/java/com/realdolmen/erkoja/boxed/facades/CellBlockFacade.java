package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.mappers.CellBlockMapper;
import com.realdolmen.erkoja.boxed.repositories.CellBlockRepository;
import com.realdolmen.erkoja.boxed.services.CellBlockService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CellBlockFacade implements Serializable{

    public CellBlockFacade() {
    }
    
    @Inject
    private CellBlockService cellBlockService;
    @Inject
    private CellBlockMapper cellBlockMapper;
    
    public List<CellBlockDto> findAll(){
        List<CellBlock> cellBlocks = cellBlockService.findAll();
        List<CellBlockDto> cellBlockDtos = new ArrayList<>();
        for(CellBlock cb : cellBlocks){
            cellBlockDtos.add(cellBlockMapper.apply(cb));
        }
        return cellBlockDtos;
    }
}
