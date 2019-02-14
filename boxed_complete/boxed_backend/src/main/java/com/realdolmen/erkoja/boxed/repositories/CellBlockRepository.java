
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class CellBlockRepository extends AbstractRepository<CellBlock,String> implements Serializable{
    
    @Produces
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
     public CellBlockRepository() {
        super(CellBlock.class);
    }
     
    public CellBlockRepository(EntityManager em) {
        super(CellBlock.class);
        this.em = em;
    }

    @Override
    protected EntityManager em() {
        return this.em;
    }
}
