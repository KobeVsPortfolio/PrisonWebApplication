
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Guard;
import javax.persistence.EntityManager;

public class GuardRepository extends AbstractRepository<Guard,Integer>{

public GuardRepository(EntityManager em) {
        super(em, Guard.class);
    }

}


