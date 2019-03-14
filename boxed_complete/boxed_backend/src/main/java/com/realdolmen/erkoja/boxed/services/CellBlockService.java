package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.repositories.CellBlockRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class CellBlockService implements Serializable{

    @Inject
    private CellBlockRepository cellBlockRepository;
    
    public CellBlockService() {
    }
    
    public List<CellBlock> findAll(){
        return cellBlockRepository.findAll();
    }
    
}
