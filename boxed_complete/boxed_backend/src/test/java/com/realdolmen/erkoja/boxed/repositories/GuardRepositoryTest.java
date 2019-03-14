package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Guard;
import java.util.List;
import javax.persistence.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GuardRepositoryTest {
         private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static GuardRepository guardRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        guardRepository = new GuardRepository(entityManager);
    }

    @Test
    public void findGuardByIdTest() {
        Guard guard = guardRepository.findById(1);
        assertNotNull(guard);
    }
    
    @Test
    public void findAllGuardsTest(){
        List<Guard> guard = guardRepository.findAll();
        assertNotNull(guard);
    }

    @Test
    public void saveGuard(){
        Guard g = new Guard();
        g.setName("Jan");
        guardRepository.begin();
        guardRepository.save(g);
        guardRepository.commit();
        assertEquals(entityManager.find(Guard.class, 4).getName(),"Jan");
    }

    @Test
    public void updateGuardTest(){
        Guard g = entityManager.find(Guard.class, 2);
        g.setName("Leon");
        guardRepository.update(g);
        assertEquals("Leon", entityManager.find(Guard.class, 2).getName());   
    }
    
        @Test
    public void deleteGuardTest(){
        guardRepository.delete(3);
        assertNull(entityManager.find(Guard.class,3));
    }


    @After
    public void exit() {
        guardRepository.close();
    }

    @AfterClass
    public static void exitClass(){
        entityManagerFactory.close();
    }
}
