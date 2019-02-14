package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PrisonerRepository extends AbstractRepository<Prisoner, Integer> implements Serializable {

    @Produces
    @PersistenceContext
    private EntityManager em;
    
     @PostConstruct
    public void init(){
       System.out.println("PersonRepository constructed "+(em == null));
    }

    public PrisonerRepository() {
        super(Prisoner.class);
    }

    public PrisonerRepository(EntityManager em) {
        super(Prisoner.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }

    public List findPrisonersToRelease(Integer currentDay) {
        Query q = em.createNamedQuery(Prisoner.FIND_TORELEASE, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersToRelease = q.getResultList();
        return prisonersToRelease;
    }

    public List findPrisonersInIsolation(Integer currentDay) {
        Query q = em.createNamedQuery(Prisoner.FIND_INISOLATION, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersInIsolation = q.getResultList();
        return prisonersInIsolation;
    }

    public List findPrisonersWithFinishedJob(Integer currentDay) {
        Query q = em.createNamedQuery(Prisoner.FIND_JOBS, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersWithJob = q.getResultList();
        return prisonersWithJob;
    }
}
