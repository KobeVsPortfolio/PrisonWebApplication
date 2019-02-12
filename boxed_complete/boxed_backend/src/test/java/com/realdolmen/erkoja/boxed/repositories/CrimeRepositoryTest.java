
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
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


public class CrimeRepositoryTest {
     private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static CrimeRepository crimeRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        crimeRepository = new CrimeRepository(entityManager);
    }

    @Test
    public void findCrimeByIdTest() {
        Crime crime = crimeRepository.findById(1);
        assertNotNull(crime);
    }
    
    @Test
    public void findAllCrimesTest(){
        List<Crime> crime = crimeRepository.findAll();
        assertNotNull(crime);
    }

    @Test
    public void saveCrime() throws Exception {
        Crime cr = new Crime();
        cr.setName("fight");
        cr.setPunishment(14);
        crimeRepository.begin();
        crimeRepository.save(cr);
        crimeRepository.commit();
        assertEquals(entityManager.find(Crime.class, 4).getName(), "fight");
        
    }

    @Test
    public void updateCrimeTest(){
        Crime cr = entityManager.find(Crime.class, 2);
        cr.setName("diefstal");
        crimeRepository.update(cr);
        assertEquals("diefstal", entityManager.find(Crime.class, 2).getName());   
    }
    
        @Test
    public void deleteCrimeTest(){
        crimeRepository.delete(3);
        assertNull(entityManager.find(Crime.class,3));
    }


    @After
    public void exit() {
        crimeRepository.close();
    }

    @AfterClass
    public static void exitClass(){
        entityManagerFactory.close();
    }

}
