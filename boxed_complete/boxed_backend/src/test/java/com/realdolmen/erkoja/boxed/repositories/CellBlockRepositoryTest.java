
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import java.util.ArrayList;
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


public class CellBlockRepositoryTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static CellBlockRepository cellBlockRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        cellBlockRepository = new CellBlockRepository(entityManager);
    }

    @Test
    public void findCellBlockByIdTest() {
        CellBlock cellblock = cellBlockRepository.findById("A");
        assertNotNull(cellblock);
    }
    
    @Test
    public void findAllCellBlocksTest(){
        List<CellBlock> cellBlock = cellBlockRepository.findAll();
        assertNotNull(cellBlock);
    }

    @Test
    public void saveCellBlock() throws Exception {
        CellBlock cb = new CellBlock();
        cb.setCellBlockId("D");
        cellBlockRepository.begin();
        cellBlockRepository.save(cb);
        cellBlockRepository.commit();
        assertNotNull(entityManager.find(CellBlock.class, "D"));
    }

    @Test
    public void deleteCellBlockTest(){
        cellBlockRepository.delete("C");
        assertNull(entityManager.find(CellBlock.class,"C"));
    }

    @Test
    public void updateCellBlockTest(){
        CellBlock cb = entityManager.find(CellBlock.class, "B");
        List<Cell> cells = new ArrayList<>();
        Cell cell = new Cell();
        cell.setCellBlock(cb);
        cells.add(cell); 
        cb.setCells(cells);
        assertEquals(cells, entityManager.find(CellBlock.class, "B").getCells());
        
    }


    @After
    public void exit() {
        cellBlockRepository.close();
    }

    @AfterClass
    public static void exitClass(){
        entityManagerFactory.close();
    }

}
    

