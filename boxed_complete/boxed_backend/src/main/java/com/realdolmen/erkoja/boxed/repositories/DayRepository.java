package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Day;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DayRepository extends AbstractRepository<Day, Integer> implements Serializable{
    
    @Produces
    @PersistenceContext
    private EntityManager em;

    public DayRepository(EntityManager em) {
        super(Day.class);
        this.em = em;
    }

    public Day findHighestValue() {
        Query q = em.createNamedQuery(Day.FIND_LAST_ENTRY);
        Integer i = (Integer) q.getSingleResult();
        Day d = super.findById(i);
        return d;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }

}
