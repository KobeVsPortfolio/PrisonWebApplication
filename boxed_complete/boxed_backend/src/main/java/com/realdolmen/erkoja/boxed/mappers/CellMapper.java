package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellMapper implements Function<Cell,CellDto> {

    @Override
    public CellDto apply(Cell cell) {
        CellDto dto = new CellDto(cell.getCellId(),cell.getCellNr(),cell.getSize(),cell.isIsolationCell());
        if(cell.getCellBlock()!=null){
            CellBlockMapper cbm = new CellBlockMapper();
            CellBlock cellBlock = cell.getCellBlock();
            CellBlockDto cbDto = cbm.apply(cellBlock);
            dto.setCellBlock(cbDto);
        }
        if(cell.getPrisonerList() != null){
            PrisonerMapper pm = new PrisonerMapper();
            List<Prisoner> prisonerList = cell.getPrisonerList();
            List<PrisonerDto> prisonerDtoList = new ArrayList<>();
            for(Prisoner p : prisonerList){
                prisonerDtoList.add(pm.apply(p));
            }
            dto.setPrisonerList(prisonerDtoList);
        }
        return dto;
} 
    
    
}
