
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellBlockMapper implements Function<CellBlock,CellBlockDto> {

    @Override
    public CellBlockDto apply(CellBlock cellBlock) {
        CellBlockDto dto = new CellBlockDto(cellBlock.getCellBlockId());
        if(cellBlock.getGuards() != null){
            GuardMapper gm = new GuardMapper();
            List<Guard> guardList = cellBlock.getGuards();
            List<GuardDto> guardDtoList = new ArrayList<>();
            for(Guard g : guardList){
                guardDtoList.add(gm.apply(g));
            }
            dto.setGuards(guardDtoList);
        }
        if(cellBlock.getCells() != null){
             CellMapper cm = new CellMapper();
             List<Cell> cells = cellBlock.getCells();
             List<CellDto> cellDtos = new ArrayList<>();
             for(Cell c : cells){
                 cellDtos.add(cm.apply(c));
             }
             dto.setCells(cellDtos);
            }
        return dto;
    }
} 
 
