
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Guard;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GuardRepository extends AbstractRepository<Guard,Integer> implements Serializable{

    @Produces
    @PersistenceContext
    private EntityManager em;

    public GuardRepository() {
        super(Guard.class);
    }

    public GuardRepository(EntityManager em) {
        super(Guard.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }


}


