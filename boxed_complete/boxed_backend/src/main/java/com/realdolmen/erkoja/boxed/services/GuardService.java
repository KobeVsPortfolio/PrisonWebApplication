
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.repositories.GuardRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class GuardService implements Serializable{
    
    @Inject
    private GuardRepository guardRepository;
    
    public GuardService() {
    }
    
    public List<Guard> findAll(){
        return guardRepository.findAll();
    }
}
