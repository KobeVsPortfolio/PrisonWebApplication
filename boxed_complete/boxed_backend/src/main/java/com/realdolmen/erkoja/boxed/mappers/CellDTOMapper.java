package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellDTOMapper implements Function<CellDto, Cell> {

    @Override
    public Cell apply(CellDto c) {
        Cell cell = new Cell(c.getCellId(), c.getCellNr(), c.getSize(), c.isIsolationCell());
        if (c.getCellBlock() != null) {
            CellBlockDTOMapper cbm = new CellBlockDTOMapper();
            CellBlockDto cDto = c.getCellBlock();
            CellBlock cellBlock = cbm.apply(cDto);
            cell.setCellBlock(cellBlock);
        }
        if (c.getPrisonerList() != null) {
            List<PrisonerDto> prisonerDtoList = c.getPrisonerList();
            List<Prisoner> prisonerList = new ArrayList<>();
            for (PrisonerDto p : prisonerDtoList) {
                Prisoner prisoner = new Prisoner();

                if (p.getId() != null) {
                    Integer id = p.getId();
                    prisoner.setId(id);
                }

                if (p.getName() != null) {
                    String name = p.getName();
                    prisoner.setName(name);
                }

                if (p.getCrimes() != null) {
                    CrimeDTOMapper cm = new CrimeDTOMapper();
                    List<CrimeDto> crimeDtos = p.getCrimes();
                    List<Crime> crimes = new ArrayList<>();
                    for (CrimeDto cDto : crimeDtos) {
                        crimes.add(cm.apply(cDto));
                    }
                    prisoner.setCrimes(crimes);
                }
                
                if (p.getReleaseDate() != null) {
                    Integer release = p.getReleaseDate();
                    prisoner.setReleaseDate(release);
                } 
                prisoner.setCell(cell);
                prisonerList.add(prisoner);
            }
            
            cell.setPrisonerList(prisonerList);
            
        }
        return cell;
    }
    
}
