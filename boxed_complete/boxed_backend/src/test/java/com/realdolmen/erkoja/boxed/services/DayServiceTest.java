package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.repositories.DayRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DayServiceTest {
    
    private DayService dayService;
    
    @Mock
    DayRepository dayRepository;
    @Mock
    PrisonerHandler prisonerHandler;
    
    @Before
    public void init(){
        dayService = new DayService(dayRepository, prisonerHandler);
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
        verify(dayRepository, times(1)).findHighestValue();
        verify(prisonerHandler, times(1)).setCurrentDay(Mockito.<Day>anyObject());
    }
    
    @Test
    public void dayProceduresTest(){
        dayService.dayProcedures();
        verify(prisonerHandler, times(1)).handlePrisoners();
    }
}
