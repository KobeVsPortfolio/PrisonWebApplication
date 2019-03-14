
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.mappers.PrisonerMapper;
import com.realdolmen.erkoja.boxed.services.PrisonerService;
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
public class PrisonerFacadeTest {
    
    @Mock
    private PrisonerService prisonerService;
    
    @Mock
    private PrisonerMapper prisonerMapper;
    
    @InjectMocks
    private PrisonerFacade prisonerFacade;

    @Test
    public void FindAllPrisonerandAddPrisonerTestDto(){
        List<Prisoner> prisoners = new ArrayList<>();
        Prisoner prisoner = new Prisoner();
        prisoner.setId(8);
        prisoners.add(prisoner);
        List<PrisonerDto> result = prisonerFacade.findAll();
        when(prisonerService.findAll()).thenReturn(prisoners);
        assertNotNull(result);   
    }
}
