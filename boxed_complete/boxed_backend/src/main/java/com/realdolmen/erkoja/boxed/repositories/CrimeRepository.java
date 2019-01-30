
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Crime;
import javax.persistence.EntityManager;


public class CrimeRepository extends AbstractRepository<Crime,Integer>{

public CrimeRepository(EntityManager em) {
        super(em, Crime.class);
    }
    
}
