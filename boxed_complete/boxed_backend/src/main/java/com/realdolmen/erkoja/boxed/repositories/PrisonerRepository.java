package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrisonerRepository extends AbstractRepository<Prisoner, Integer> {

    public PrisonerRepository(EntityManager em) {
        super(em, Prisoner.class);
    }
    
    public List findPrisonersToRelease(Integer currentDay){
        Query q = em.createNamedQuery(Prisoner.FIND_TORELEASE, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersToRelease = q.getResultList();
        return prisonersToRelease;
    }
    
    public List findPrisonersInIsolation(Integer currentDay){
        Query q = em.createNamedQuery(Prisoner.FIND_INISOLATION, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersInIsolation = q.getResultList();
        return prisonersInIsolation;
    }   
        public List findPrisonersWithFinishedJob(Integer currentDay){
        Query q = em.createNamedQuery(Prisoner.FIND_JOBS, Prisoner.class);
        q.setParameter("currentDate", currentDay);
        List<Prisoner> prisonersWithJob = q.getResultList();
        return prisonersWithJob;
    }   
}
