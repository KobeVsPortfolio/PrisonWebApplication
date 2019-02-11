
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import com.realdolmen.erkoja.boxed.mappers.GuardMapper;
import com.realdolmen.erkoja.boxed.services.GuardService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


public class GuardFacade implements Serializable{ 

      @Inject
    private GuardService guardService;

    public GuardFacade() {
    }

    public List<GuardDto> findAllGuards() {
        List<Guard> guards = guardService.findAll();
        return guards.stream()
                .map(cell -> new GuardMapper().apply(cell))
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .collect(Collectors.toList());
    } 
}
