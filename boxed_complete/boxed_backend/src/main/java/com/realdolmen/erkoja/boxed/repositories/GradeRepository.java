
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Grade;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class GradeRepository extends AbstractRepository<Grade,Integer> implements Serializable{

    @Produces
    @PersistenceContext
    private EntityManager em;

    public GradeRepository() {
        super(Grade.class);
    }

    public GradeRepository(EntityManager em) {
        super(Grade.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }

}
