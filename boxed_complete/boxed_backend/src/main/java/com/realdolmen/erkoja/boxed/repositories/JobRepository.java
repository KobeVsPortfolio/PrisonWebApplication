
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JobRepository extends AbstractRepository<Job,Integer> implements Serializable{

    @Produces
    @PersistenceContext
    private EntityManager em;

    public JobRepository() {
        super(Job.class);
    }

    public JobRepository(EntityManager em) {
        super(Job.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }

}
