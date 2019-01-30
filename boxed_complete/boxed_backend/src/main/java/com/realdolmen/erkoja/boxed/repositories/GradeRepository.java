
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Grade;
import javax.persistence.EntityManager;


public class GradeRepository extends AbstractRepository<Grade,Integer>{

public GradeRepository(EntityManager em) {
        super(em, Grade.class);
    }
    
}
