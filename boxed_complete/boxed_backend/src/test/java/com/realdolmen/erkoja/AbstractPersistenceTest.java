package com.realdolmen.erkoja;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AbstractPersistenceTest {
    
    private static EntityManagerFactory emf;
    protected EntityManager em;
    
    EntityTransaction etx;

    @BeforeClass
    public static void initializeEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("BoxedPersistenceTestUnit");
    }

    @Before
    public void initializeEntityManagerWithTransaction() {
        // TODO: initialize the entity manager from the entity manager factory here
        em = emf.createEntityManager();
        // TODO: begin a transaction
        etx = em.getTransaction();
        etx.begin();
    }

    @After
    public void rollbackTransactionAndCloseEntityManager() {
        etx.commit();
        //etx.rollback();
        em.close();
        
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        // TODO; close the EntityManagerFactory
        emf.close();
    }
}
