package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import java.util.List;
import javax.persistence.Persistence;


public class CellService{
    
    private CellRepository cellRepository;

    public CellService() {
        this.cellRepository = new CellRepository(Persistence.createEntityManagerFactory("BoxedPersistenceUnit").createEntityManager());
    }
    
    

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }
    
    public void addPrisoner(Prisoner prisoner, Cell cell){
        if(cell.getPrisonerList().size()< cell.getSize()){
            List<Prisoner> prisonerList = cell.getPrisonerList();
            prisonerList.add(prisoner);
            cell.setPrisonerList(prisonerList);
            cellRepository.update(cell);
        } 
    }
    
    public void removePrisoner(Prisoner prisoner, Cell cell){
        if(cell.getPrisonerList().contains(prisoner) && cell.getPrisonerList().size()>0){
            List<Prisoner> prisonerList = cell.getPrisonerList();
            prisonerList.remove(prisoner);
            cell.setPrisonerList(prisonerList);
            cellRepository.update(cell);
        } 
    }
    
    public List<Cell> findAllCells() {
        return cellRepository.findAll();
    }
}
