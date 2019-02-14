
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.List;
import javax.inject.Inject;

public class PrisonerService {
        @Inject
    private PrisonerRepository prisonerRepository;
    
    public PrisonerService() {
    }
    
    public List<Prisoner> findAll(){
        return prisonerRepository.findAll();
    }

}
