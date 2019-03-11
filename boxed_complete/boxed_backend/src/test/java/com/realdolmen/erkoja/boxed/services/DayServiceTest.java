package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.repositories.DayRepository;
import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceTest implements Serializable{
    
    @InjectMocks
    private DayService dayService;
    
    @Mock
    DayRepository dayRepository;
    @Mock
    PrisonerHandler prisonerHandler;
    
    @Before
    public void init(){
    }
    
    
    @Test
    public void getCurrentDayTest(){
        when(dayRepository.findHighestValue()).thenReturn(new Day(0));
        Day d = dayService.getCurrentDay();
        
        assertEquals(0, d.getDayNr().intValue());
        verify(dayRepository, times(1)).findHighestValue();
    }
    
    @Test
    public void newDayTest(){
        dayService.newDay();
        verify(dayRepository, times(1)).save(Mockito.<Day>anyObject());
    }
}
