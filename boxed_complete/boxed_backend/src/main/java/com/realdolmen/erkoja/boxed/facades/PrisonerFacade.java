
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.mappers.PrisonerMapper;
import com.realdolmen.erkoja.boxed.services.PrisonerService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


public class PrisonerFacade implements Serializable{
    
    @Inject
    private PrisonerService prisonerService;

    public PrisonerFacade() {
    }
  
    public List<PrisonerDto> findAll() {
        List<Prisoner> prisoners = prisonerService.findAll();
        return prisoners.stream()
                .map(cell -> new PrisonerMapper().apply(cell))
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .collect(Collectors.toList());
    } 
}
