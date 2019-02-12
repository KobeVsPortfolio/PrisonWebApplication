
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.dtos.DayDto;
import com.realdolmen.erkoja.boxed.mappers.DayMapper;
import com.realdolmen.erkoja.boxed.services.DayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DayFacadeTest {
    
    @Mock
     private DayService dayService;
    @Mock
    private DayMapper dayMapper;
    @InjectMocks
    private DayFacade dayFacade;
    
    @Test
    public void FindAllDayandAddDayTestDto(){
        Day day = new Day();
        day.setDayNr(5);
        DayDto dayDto = new DayDto();
        dayDto.setDayNr(6);
        when(dayService.getCurrentDay()).thenReturn(day);
        when(dayMapper.apply(dayService.getCurrentDay())).thenReturn(dayDto);
        

        
        
        

    }
    
   
    
}
