
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import com.realdolmen.erkoja.boxed.mappers.GuardMapper;
import com.realdolmen.erkoja.boxed.services.GuardService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GuardFacadeTest {
    @Mock
     private GuardService guardService;
    @Mock
    private GuardMapper guardMapper;
    @InjectMocks
    private GuardFacade guardFacade;

    @Test
    public void FindAllGuardandAddGuardTestDto(){
        List<Guard> guards = new ArrayList<>();
        Guard guard = new Guard();
        guard.setId(1);
        guards.add(guard);
        List<GuardDto> result = guardFacade.findAllGuards();
        when(guardService.findAll()).thenReturn(guards);
        assertNotNull(result);
        
        
    
    }
}
