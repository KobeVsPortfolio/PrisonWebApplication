
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import java.util.function.Function;

public class GuardDTOMapper implements Function<GuardDto,Guard> {

    @Override
    public Guard apply(GuardDto g) {
        Guard guard = new Guard(g.getGrade());
        
        if(g.getId()!=null){
            Integer id = g.getId();
            guard.setId(id);
        }
        
        if(g.getName()!=null){
            String name = g.getName();
            guard.setName(name);
        }
        
        if(g.getCellBlock() != null){
            CellBlockDTOMapper cbm = new CellBlockDTOMapper();
            CellBlockDto cellBlockDto = g.getCellBlock();
            CellBlock cellBlock = cbm.apply(cellBlockDto);
            guard.setCellBlock(cellBlock);
        }
        return guard;
    }
} 
