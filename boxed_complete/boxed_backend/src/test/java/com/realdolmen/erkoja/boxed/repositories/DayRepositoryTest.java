package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Day;
import java.util.List;
import javax.persistence.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DayRepositoryTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static DayRepository dayRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        dayRepository = new DayRepository(entityManager);
    }

    @Test
    public void findDayByIdTest() {
        Day day = new Day();
        dayRepository.save(day);
        day = dayRepository.findById(1);
        assertNotNull(day);
    }

    @Test
    public void findAllDaysTest() {
        Day day = new Day();
        dayRepository.save(day);
        List<Day> days = dayRepository.findAll();
        assertNotNull(days);
    }

    @Test
    public void saveDay() throws Exception {
        List<Day> initial = dayRepository.findAll();
        Day day = new Day();
        dayRepository.begin();
        dayRepository.save(day);
        dayRepository.commit();
        List<Day> afterSave = dayRepository.findAll();
        assertEquals(initial.size(), afterSave.size() - 1);
    }

    @Test
    public void deleteDayTest() {
        Day day = new Day();
        dayRepository.save(day);
        dayRepository.save(day);
        dayRepository.delete(2);
        assertNull(entityManager.find(Day.class, 2));
    }

    @Test
    public void findHighestValueTest() {
        dayRepository.save(new Day());
        List<Day> allDays = dayRepository.findAll();
        Integer theoreticalLastDay = allDays.get(allDays.size()-1).getDayNr();
        assertEquals(theoreticalLastDay, dayRepository.findHighestValue().getDayNr());
    }

    @After
    public void exit() {
        dayRepository.close();
    }

    @AfterClass
    public static void exitClass() {
        entityManagerFactory.close();
    }

}
