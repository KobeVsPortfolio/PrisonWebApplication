package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
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

public class PrisonerRepositoryTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static PrisonerRepository prisonerRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        prisonerRepository = new PrisonerRepository(entityManager);
    }

    @Test
    public void findPrisonerByIdTest() {
        Prisoner prisoner = prisonerRepository.findById(1);
        assertNotNull(prisoner);
    }

    @Test
    public void findAllPrisonerTest() {
        List<Prisoner> prisoner = prisonerRepository.findAll();
        assertNotNull(prisoner);
    }

    @Test
    public void savePrisoner() {
        Prisoner p = new Prisoner();
        p.setName("Jaak");
        p.setReleaseDate(700);
        prisonerRepository.save(p);
        assertEquals(entityManager.find(Prisoner.class, 4).getName(), "Jaak");
    }

    @Test
    public void updatePrisonerTest() {
        Prisoner p = entityManager.find(Prisoner.class, 2);
        p.setName("Jon");
        prisonerRepository.update(p);
        assertEquals("Jon", entityManager.find(Prisoner.class, 2).getName());
    }

    @Test
    public void deletePrisonerTest() {
        prisonerRepository.delete(3);
        assertNull(entityManager.find(Prisoner.class, 3));
    }

    @Test
    public void findPrisonersToRelease() {
        List<Prisoner> result = prisonerRepository.findPrisonersToRelease(100);
        assertEquals(2, result.size());
        result = prisonerRepository.findPrisonersToRelease(50);
        assertEquals(1, result.size());

    }

    @After
    public void exit() {
        prisonerRepository.close();
    }

    @AfterClass
    public static void exitClass() {
        entityManagerFactory.close();
    }

}
