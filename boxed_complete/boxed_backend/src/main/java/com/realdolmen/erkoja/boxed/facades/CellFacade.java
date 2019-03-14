
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.services.CellService;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.mappers.CellDTOMapper;
import com.realdolmen.erkoja.boxed.mappers.CellMapper;
import com.realdolmen.erkoja.boxed.mappers.PrisonerDTOMapper;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class CellFacade implements Serializable {

    @Inject
    private CellService cellService;

    public CellFacade() {
    }
   
    public List<CellDto> findAllCells() {
        List<Cell> cells = cellService.findAllCells();
        return cells.stream()
                .map(cell -> new CellMapper().apply(cell))
                .sorted((c1, c2) -> c1.getCellNr().compareTo(c2.getCellNr()))
                .collect(Collectors.toList());
    }
    
    public CellDto findCellById(Integer id){
       Cell cell = cellService.findCellById(id);
       CellMapper cm = new CellMapper();
       CellDto c = cm.apply(cell);
       return c;
    }
    
    public void addPrisoner(PrisonerDto pDto, CellDto cDto){
        CellDTOMapper cdm = new CellDTOMapper();
        PrisonerDTOMapper pdm = new PrisonerDTOMapper();
        Prisoner p = pdm.apply(pDto);
        Cell c = cdm.apply(cDto);
        cellService.addPrisoner(p, c);
    }
}
