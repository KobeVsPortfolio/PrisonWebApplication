
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.services.CrimeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrimeFacadeTest {
    @Mock
     private CrimeService crimeService;
    
    @InjectMocks
    private CrimeFacade crimeFacade;
    
    @Test
    public void FindAllCrimeandAddCrimeTestDto(){
        List<Crime> crimes = new ArrayList<>();
        Crime crime = new Crime();
        crime.setId(5);
        crimes.add(crime);
        List<CrimeDto> result = crimeFacade.findAll();
        when(crimeService.findAll()).thenReturn(crimes);
        assertNotNull(result);
    }
    
    
    
    
}
