
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.services.CellService;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.mappers.CellMapper;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class CellFacade implements Serializable {

    @Inject
    private CellService cellService;

    public CellFacade() {
    }
    
    @PostConstruct
    public void init(){
        System.out.println("CellFacade constructed");
    }

    public List<CellDto> findAllPersons() {
        List<Cell> cells = cellService.findAllCells();
        return cells.stream()
                .map(cell -> new CellMapper().apply(cell))
                .sorted((c1, c2) -> c1.getCellNr().compareTo(c2.getCellNr()))
                .collect(Collectors.toList());
    } 
}
