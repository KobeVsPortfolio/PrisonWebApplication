package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CrimeRepository extends AbstractRepository<Crime, Integer> implements Serializable{
    
    @Produces
    @PersistenceContext
    private EntityManager em;

    public CrimeRepository() {
        super(Crime.class);
    }

    public CrimeRepository(EntityManager em) {
        super(Crime.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }

}
