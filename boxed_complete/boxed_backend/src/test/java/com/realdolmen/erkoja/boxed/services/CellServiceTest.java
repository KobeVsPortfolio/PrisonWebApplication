package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellServiceTest {
    
    CellService cellService;
    Prisoner p1, p2, p3;
    Cell c1, c2, c3;
    List <Prisoner> initialPrisonerList;
    
    @Mock
    CellRepository cellRepository;
    
    @Before
    public void init(){
        cellService = new CellService(cellRepository);
        p1 = new Prisoner();
        p2 = new Prisoner();
        p3 = new Prisoner();
        p1.setName("p1");
        p2.setName("p2");
        p3.setName("p3");
        initialPrisonerList = new ArrayList<>();
        c1 = new Cell();
        c1.setSize(2);
        
        
    }
    
    @Test
    public void addPrisonerTestPrisonerAdded(){
        initialPrisonerList.add(p1);
        c1.setPrisonerList(new ArrayList<>());
        cellService.addPrisoner(p1, c1);
        cellService.addPrisoner(p2, c1);
        List<Prisoner> listAfterAdd = c1.getPrisonerList();
        assertNotEquals(initialPrisonerList,listAfterAdd);
        assertEquals(initialPrisonerList.size() + 1, listAfterAdd.size());
        verify(cellRepository, times(2)).update(c1);
    }
    
    @Test
    public void addPrisonerTestPrisonerNotAdded(){
        initialPrisonerList.add(p1);
        initialPrisonerList.add(p2);
        c1.setPrisonerList(initialPrisonerList);
        cellService.addPrisoner(p3, c1);
        List<Prisoner> listAfterAdd = c1.getPrisonerList();
        assertEquals(initialPrisonerList, listAfterAdd);
        Mockito.verifyNoMoreInteractions(cellRepository);
    }
    
    @Test
    public void removePrisonerTestPrisonerRemoved(){
        c1.setPrisonerList(new ArrayList<>());
        cellService.addPrisoner(p1, c1);
        assertEquals(c1.getPrisonerList().size(), 1);
        cellService.removePrisoner(p1, c1);
        assertEquals(c1.getPrisonerList().size(), 0);
        verify(cellRepository, times(2)).update(c1);
    }
    
    @Test
    public void removePrisonerTestPrisonerNotRemoved(){
        c1.setPrisonerList(initialPrisonerList);
        cellService.removePrisoner(p3, c1);
        List<Prisoner> listAfterAdd = c1.getPrisonerList();
        assertEquals(initialPrisonerList, listAfterAdd);
        verifyNoMoreInteractions(cellRepository);
    }
}
