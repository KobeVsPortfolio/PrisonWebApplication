package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Day;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DayRepository extends AbstractRepository<Day, Integer> {

    public DayRepository(EntityManager em) {
        super(em, Day.class);
    }

    public Day findHighestValue() {
        Query q = em.createNamedQuery(Day.FIND_LAST_ENTRY);
        Integer i = (Integer) q.getSingleResult();
        Day d = super.findById(i);
        return d;
    }

}
