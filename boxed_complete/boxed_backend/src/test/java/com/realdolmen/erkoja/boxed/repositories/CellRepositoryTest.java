
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Cell;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CellRepositoryTest {
 private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static CellRepository cellRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        cellRepository = new CellRepository(entityManager);
    }

    @Test
    public void findCellByIdTest() {
        Cell cell = cellRepository.findById(1);
        assertNotNull(cell);
    }
    
    @Test
    public void findAllCellsTest(){
        List<Cell> cell = cellRepository.findAll();
        assertNotNull(cell);
    }

    @Test
    public void saveCell() throws Exception {
        Cell c = new Cell();
        c.setCellNr("123");
        c.setSize(1);
        cellRepository.save(c);
        assertNotNull(entityManager.find(Cell.class, 4));
        
    }

    @Test
    public void updateCellTest(){
        Cell cell = entityManager.find(Cell.class, 2);
        cell.setCellNr("123C");
        cellRepository.update(cell);
        assertEquals("123C", entityManager.find(Cell.class, 2).getCellNr());
    }
    
    @Test
    public void deleteCellTest(){
        cellRepository.delete(3);
        assertNull(entityManager.find(Cell.class,3));
    }
    
    @Test
    public void findIsolationCellByCellBlockTestFindsCell(){
        Cell result = cellRepository.findEmptyIsolationCellByCellBlock("B");
        
        assertEquals("B2", result.getCellNr());
        
    }


    @After
    public void exit() {
        cellRepository.close();
    }

    @AfterClass
    public static void exitClass(){
        entityManagerFactory.close();
    }
    
}
