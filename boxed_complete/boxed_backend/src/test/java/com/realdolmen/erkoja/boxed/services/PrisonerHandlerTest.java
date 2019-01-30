package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrisonerHandlerTest {
    
    private PrisonerHandler prisonerHandler;
    Day currentDay;
    Integer currentDayNr;
    
    @Mock
    PrisonerRepository prisonerRepository;
    
    @Mock
    CellRepository cellRepository;
    
    @Before
    public void init(){
        prisonerHandler = new PrisonerHandler(prisonerRepository, cellRepository);
        currentDay = new Day(1);
        currentDayNr = currentDay.getDayNr();
    }
    
    @Test
    public void testReleasePrisoners(){
        List<Prisoner> prisonerList = new ArrayList<>();
        Prisoner p1 = new Prisoner();
        Prisoner p2 = new Prisoner();
        p1.setId(1);
        p2.setId(2);
        prisonerList.add(p1);
        prisonerList.add(p2);
        prisonerHandler.setCurrentDay(currentDay);
        when(prisonerRepository.findPrisonersToRelease(currentDayNr)).thenReturn(prisonerList);
        prisonerHandler.releasePrisoners();
        verify(prisonerRepository, times(1)).findPrisonersToRelease(currentDayNr);
        verify(prisonerRepository, times(1)).delete(2);
        verify(prisonerRepository, times(1)).delete(1);
        verifyNoMoreInteractions(prisonerRepository);
    }

    
    
}
