package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;


public class CellService implements Serializable{
    
    @Inject
    private CellRepository cellRepository;
    
    @Inject
    private PrisonerRepository prisonerRepository;

    public CellService() {
    }

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }
    
    public void addPrisoner(Prisoner prisoner, Cell cell){
        if(cell.getPrisonerList().size() < cell.getSize()){
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
    
    public Cell findCellById(Integer id){
        return cellRepository.findById(id);
    }
}
