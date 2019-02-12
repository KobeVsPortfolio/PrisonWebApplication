
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Job;
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

public class JobRepositoryTest {
     private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private static JobRepository jobRepository;

    @BeforeClass
    public static void initClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void init() {
        entityManager = entityManagerFactory.createEntityManager();
        jobRepository = new JobRepository(entityManager);
    }

    @Test
    public void findJobByIdTest() {
        Job job = jobRepository.findById(1);
        assertNotNull(job);
    }
    
    @Test
    public void findAllJobsTest(){
        List<Job> jobs = jobRepository.findAll();
        assertNotNull(jobs);
    }

    @Test
    public void saveJob() throws Exception {
        Job j = new Job();
        j.setName("washer");
        j.setDuration(120);
        jobRepository.begin();
        jobRepository.save(j);
        jobRepository.commit();
        assertEquals(entityManager.find(Job.class, 4).getName(), "washer");
    }

    @Test
    public void updateJobTest(){
        Job j = entityManager.find(Job.class, 2);
        j.setName("diefstal");
        jobRepository.update(j);
        assertEquals("diefstal", entityManager.find(Job.class, 2).getName());   
    }
    
        
    @Test
    public void deleteJobTest(){
        jobRepository.delete(3);
        assertNull(entityManager.find(Job.class, 3));
    }

    @After
    public void exit() {
        jobRepository.close();
    }

    @AfterClass
    public static void exitClass(){
        entityManagerFactory.close();
    }
}
