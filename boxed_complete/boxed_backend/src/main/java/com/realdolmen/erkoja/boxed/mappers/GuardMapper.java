
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import java.util.function.Function;

public class GuardMapper implements Function<Guard, GuardDto> {

    @Override
    public GuardDto apply(Guard guard) {
        GuardDto dto = new GuardDto(guard.getId(), guard.getName(), guard.getGrade());
        if(guard.getCellBlock() != null){
            CellBlockMapper cbm = new CellBlockMapper();
            CellBlock cellBlock = guard.getCellBlock();
            CellBlockDto cellBlockDto = cbm.apply(cellBlock);
            dto.setCellBlock(cellBlockDto);
        }
        return dto;
    }
} 

