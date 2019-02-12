
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.repositories.CrimeRepository;
import java.util.List;
import javax.inject.Inject;

public class CrimeService {
@Inject
    private CrimeRepository crimeRepository;
    
    public CrimeService() {
    }
    
    public List<Crime> findAll(){
        return crimeRepository.findAll();
    }

    
}
