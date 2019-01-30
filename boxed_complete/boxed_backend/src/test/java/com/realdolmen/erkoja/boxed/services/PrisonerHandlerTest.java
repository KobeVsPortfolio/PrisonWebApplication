package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.JobRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
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
    
    @Mock
    CellService cellService;
    
    @Mock
    DayService dayService;
    
    @Mock
    JobRepository jobRepository;
    
    @Before
    public void init(){
        prisonerHandler = new PrisonerHandler(prisonerRepository, cellRepository, cellService, dayService, jobRepository);
    }   
    
    @Ignore
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
    @Test
    public void movePrisonersTest() {
        Prisoner p1 = new Prisoner();
        Cell C1 = new Cell();
        Cell A2 = new Cell();
        prisonerHandler.movePrisoners(C1, A2, p1);
        verify(cellService, times(1)).removePrisoner(p1, C1);
        verify(cellService, times(1)).addPrisoner(p1, A2);
    }
    @Test
    public void sendToIsolationTest(){
        Prisoner p2 = new Prisoner();
        Cell A1 = new Cell();
        Cell A2 = new Cell();
        CellBlock cb = new CellBlock();
        cb.setCellBlockId("A");
        A1.setCellBlock(cb);
        p2.setCell(A1);
        p2.setReleaseDate(1);
        p2.setIsolated(1);
        when(cellRepository.findEmptyIsolationCellByCellBlock(cb.getCellBlockId())).thenReturn(A2);
        when(dayService.getCurrentDay()).thenReturn(new Day(1));
        prisonerHandler.sendToIsolation(p2); 
        verify(cellRepository, times(1)).findEmptyIsolationCellByCellBlock(cb.getCellBlockId());
    } 
       @Ignore
    public void moveOutOfIsolationCellTest(){
        Prisoner p1 = new Prisoner();
        Cell A1 = new Cell();
        CellBlock cb = new CellBlock();
        p1.setCell(A1);
        A1.setCellBlock(cb);
        cb.setCellBlockId("A");
        prisonerHandler.moveOutOfIsolation();
        verify(cellRepository, times(1)).findEmptyCellsByCellBlock(cb.getCellBlockId());
    }
    
    @Test
    public void substractReleaseDateTest(){
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        prisonerHandler.subtractReleaseDate(60, p1);
        verify(prisonerRepository, times(1)).update(p1);
    }
    @Test
    public void addToReleaseDateTest(){
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        prisonerHandler.addToReleaseDate(60, p1);
        verify(prisonerRepository, times(1)).update(p1);
    }
  
    @Ignore
    public void finishJobs(){
        when(dayService.getCurrentDay().getDayNr()).thenReturn(1);
        Job J1 = new Job();
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        p1.setJob(J1);
        prisonerHandler.finishJobs(J1, p1);
        verify(prisonerRepository, times(1)).findPrisonersWithFinishedJob(1);
        verify(prisonerHandler, times(1)).subtractReleaseDate(60, p1);
    }
  
    @Ignore
    public void giveJobTest(){
        Prisoner p3 = new Prisoner();
        Job job = new Job();
        p3.setJob(job);
        job.setDuration(60);
        prisonerHandler.giveJob(job, p3);
        verify(dayService, times(1)).getCurrentDay();
        verify(jobRepository, times(1)).update(job);
    }
}