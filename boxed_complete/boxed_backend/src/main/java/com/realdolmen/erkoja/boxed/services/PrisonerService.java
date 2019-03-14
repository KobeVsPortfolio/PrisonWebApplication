package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.exceptions.CellFullException;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;

public class PrisonerService implements Serializable {

    private List<Prisoner> prisonerList;
    
    @Inject
    private PrisonerRepository prisonerRepository;

    public PrisonerService() {
    }

    public List<Prisoner> findAll() {
        return prisonerRepository.findAll();
    }

    public void addPrisonerToCell(Prisoner prisoner, Cell cell) throws CellFullException{
        if (cell.getPrisonerList() != null) {
            if (cell.getSize() > cell.getPrisonerList().size()) {
                prisonerList = cell.getPrisonerList();
                prisonerList.add(prisoner);
                cell.setPrisonerList(prisonerList);
                prisoner.setCell(cell);
                prisonerRepository.save(prisoner);
            }else{
                throw new CellFullException("Cell is full.");
            }
        } else {
            prisonerList = new ArrayList<>();
            prisonerList.add(prisoner);
            cell.setPrisonerList(prisonerList);
            prisoner.setCell(cell);
            prisonerRepository.save(prisoner);
        }
    }
    
    public void deletePrisonerFromCell(Prisoner prisoner, Cell cell){
        if(cell.getPrisonerList() != null && prisoner != null){
            List<Prisoner> prisonerOriginalList = cell.getPrisonerList();
            prisonerList = prisonerOriginalList.stream().filter(p -> p.getId() != prisoner.getId()).collect(toList());
            cell.setPrisonerList(prisonerList);
            prisonerRepository.delete(prisoner.getId());
        }
    }
    
    public Integer findHighestPrisonerId(){
        Integer last = prisonerRepository.findAll().size();
        return last;
    }
    }

