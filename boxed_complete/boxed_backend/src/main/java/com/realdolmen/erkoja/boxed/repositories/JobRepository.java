
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Job;
import javax.persistence.EntityManager;

public class JobRepository extends AbstractRepository<Job,Integer>{

public JobRepository(EntityManager em) {
        super(em, Job.class);
    }
    
}
