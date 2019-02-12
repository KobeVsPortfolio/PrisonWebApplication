
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.mappers.CrimeMapper;
import com.realdolmen.erkoja.boxed.services.CrimeService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


public class CrimeFacade implements Serializable {
    @Inject
    private CrimeService crimeService;

    public CrimeFacade() {
    }
    
    public List<CrimeDto> findAll() {
        List<Crime> crimes = crimeService.findAll();
        return crimes.stream()
                .map(crime -> new CrimeMapper().apply(crime))
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .collect(Collectors.toList());
    } 
    
    
}
