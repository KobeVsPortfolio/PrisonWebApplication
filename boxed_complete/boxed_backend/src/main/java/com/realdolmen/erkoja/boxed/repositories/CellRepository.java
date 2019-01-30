
package com.realdolmen.erkoja.boxed.repositories;

import com.realdolmen.erkoja.boxed.domain.Cell;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CellRepository extends AbstractRepository<Cell,Integer>{

public CellRepository(EntityManager em) {
        super(em, Cell.class);
    }

public Cell findEmptyIsolationCellByCellBlock(String cellBlockId){
    Query q = em.createNamedQuery(Cell.FIND_ISOLATION_BY_CELLBLOCK);
    q.setParameter("cellBlock", cellBlockId);
    List <Cell> allCells = q.getResultList();
    for (Cell c : allCells){
        if(c.getPrisonerList().size() == 0){
            return c;
        }
    }
    return null;
}

public Cell findEmptyCellsByCellBlock(String cellBlockId){
    Query q = em.createNamedQuery(Cell.FIND_CELLS_BY_CELLBLOCK);
    q.setParameter("cellBlock", cellBlockId);
    List <Cell> allCells = q.getResultList();
    for (Cell c : allCells){
        if(c.getPrisonerList().size() < c.getSize()){
            return c;
        }
    }
    return null;
}
    
}
