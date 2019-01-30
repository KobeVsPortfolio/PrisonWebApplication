
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import javax.persistence.EntityManager;

public class CellBlockRepository extends AbstractRepository<CellBlock,String>{

public CellBlockRepository(EntityManager em) {
        super(em, CellBlock.class);
    }
    
}
