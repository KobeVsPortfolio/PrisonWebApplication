
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import java.io.Serializable;
import javax.persistence.EntityManager;

public class CellBlockRepository extends AbstractRepository<CellBlock,String>{

public CellBlockRepository(EntityManager em) {
        super(em, CellBlock.class);
    }

    public CellBlockRepository() {
        super(CellBlock.class);
    }


    
}
