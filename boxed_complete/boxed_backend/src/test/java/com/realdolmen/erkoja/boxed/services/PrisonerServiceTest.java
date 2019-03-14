
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.exceptions.CellFullException;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrisonerServiceTest {
    
    private Prisoner p1, p2, p3;
    private Cell c1, c2;
    
    @InjectMocks
    private PrisonerService prisonerService;
    
    @Mock
    private PrisonerRepository prisonerRepository;
    
    @Before
    public void init(){
        p1 = new Prisoner();
        p2 = new Prisoner();
        p3 = new Prisoner();
        p1.setName("Bob");
        p2.setName("Bert");
        p3.setName("John");
        c1 = new Cell();
        c1.setSize(2);
        c2 = new Cell();
        c2.setSize(1);
    }

    @Test
    public void addPrisonerToCellTest() throws CellFullException {
        prisonerService.addPrisonerToCell(p1, c1);
        assertNotNull(c1.getPrisonerList());
        assertEquals(c1.getPrisonerList().size(), 1);
        assertEquals(p1.getCell(), c1);
        assertTrue(c1.getPrisonerList().contains(p1));
        verify(prisonerRepository, times(1)).save(p1);
    }
    
    @Test(expected = CellFullException.class)
    public void addPrisonerToCellAlreadyFull() throws CellFullException{
        prisonerService.addPrisonerToCell(p1, c1);
        prisonerService.addPrisonerToCell(p2, c1);
        prisonerService.addPrisonerToCell(p3, c1);
        assertEquals(c1.getPrisonerList().size(), 2);
        assertEquals(p1.getCell(), c1);
    }
    
    @Test
    public void deletePrisonerFromCellTest() throws CellFullException{
        prisonerService.addPrisonerToCell(p1, c1);
        assertNotNull(c1.getPrisonerList().contains(p1));
        prisonerService.deletePrisonerFromCell(p1, c1);
        assertFalse(c1.getPrisonerList().contains(p1));
        verify(prisonerRepository, times(1)).delete(p1.getId());
    }
    
    @Test
    public void findHighestPrisonerIdTest() throws CellFullException{
        List<Prisoner> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        when(prisonerRepository.findAll()).thenReturn(pList);
        Integer test = prisonerService.findHighestPrisonerId();
        Integer last = 2;
        assertEquals(last, test);
    }
    
}
