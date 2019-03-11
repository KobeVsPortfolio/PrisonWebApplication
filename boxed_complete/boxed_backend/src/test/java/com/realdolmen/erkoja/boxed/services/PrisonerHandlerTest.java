package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.JobRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrisonerHandlerTest implements Serializable{
    
    @InjectMocks
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
    public void init() {
    }

    @Test
    public void testReleasePrisoners() {
        List<Prisoner> prisonerList = new ArrayList<>();
        Prisoner p1 = new Prisoner();
        Prisoner p2 = new Prisoner();
        p1.setId(1);
        p2.setId(2);
        p1.setReleaseDate(30);
        p2.setReleaseDate(30);
        prisonerList.add(p1);
        prisonerList.add(p2);
        when(dayService.getCurrentDay()).thenReturn(new Day(31));
        when(prisonerRepository.findPrisonersToRelease(31)).thenReturn(prisonerList);
        prisonerHandler.releasePrisoners();
        verify(prisonerRepository, times(1)).delete(p1.getId());
        verify(prisonerRepository, times(1)).delete(p2.getId());
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
    public void sendToIsolationTest() {
        Prisoner p2 = new Prisoner();
        Cell A1 = new Cell();
        Cell A2 = new Cell();
        CellBlock cb = new CellBlock();
        cb.setCellBlockId("A");
        A1.setCellBlock(cb);
        A2.setCellNr("A2");
        p2.setCell(A1);
        p2.setReleaseDate(1);
        p2.setIsolated(false);
        when(cellRepository.findEmptyIsolationCellByCellBlock(cb.getCellBlockId())).thenReturn(A2);
        when(dayService.getCurrentDay()).thenReturn(new Day(1));
        prisonerHandler.sendToIsolation(p2);
        verify(cellRepository, times(1)).findEmptyIsolationCellByCellBlock(cb.getCellBlockId());
        assertTrue(p2.getIsolated());
        assertEquals(p2.getCell().getCellNr(),"A2");
    }

    @Test
    public void moveOutOfIsolationCellTest() {
        List<Prisoner> prisonerList = new ArrayList<>();
        Prisoner p1 = new Prisoner();
        Cell A1 = new Cell();
        Cell A2 = new Cell();
        CellBlock cb = new CellBlock();
        cb.setCellBlockId("A");
        A1.setCellBlock(cb);
        p1.setCell(A1);
        prisonerList.add(p1);
        when(dayService.getCurrentDay()).thenReturn(new Day(20));
        when(prisonerRepository.findPrisonersInIsolation(20)).thenReturn(prisonerList);
        when(cellRepository.findEmptyCellsByCellBlock(p1.getCell().getCellBlock().getCellBlockId())).thenReturn(A2);
        prisonerHandler.moveOutOfIsolation();
        assertFalse(p1.getIsolated());
        assertEquals(p1.getIsolationDuration().intValue(), 0);
        verify(cellService, times(1)).removePrisoner(p1, A1);
    }
    
    @Test
    public void substractReleaseDateTest() {
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        prisonerHandler.subtractReleaseDate(60, p1);
        verify(prisonerRepository, times(1)).update(p1);
    }

    @Test
    public void addToReleaseDateTest() {
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        prisonerHandler.addToReleaseDate(60, p1);
        verify(prisonerRepository, times(1)).update(p1);
    }

    @Test
    public void finishJobs() {
        List<Prisoner> prisonerList = new ArrayList<>();
        Job J1 = new Job();
        Prisoner p1 = new Prisoner();
        p1.setReleaseDate(500);
        p1.setJob(J1);
        prisonerList.add(p1);
        when(dayService.getCurrentDay()).thenReturn(new Day(20));
        when(prisonerRepository.findPrisonersWithFinishedJob(20)).thenReturn(prisonerList);
        prisonerHandler.finishJobs();
        assertEquals(p1.getReleaseDate().intValue(), 440);
        assertEquals(p1.getJob(), null);
    }

    @Test
    public void giveJobTest() {
        Prisoner p1 = new Prisoner();
        Job job = new Job();
        job.setDuration(60);
        when(dayService.getCurrentDay()).thenReturn(new Day(20));
        prisonerHandler.giveJob(job, p1);
        verify(prisonerRepository, times(1)).update(p1);
        assertEquals(p1.getJobDuration().intValue(), 80);
    }
}
