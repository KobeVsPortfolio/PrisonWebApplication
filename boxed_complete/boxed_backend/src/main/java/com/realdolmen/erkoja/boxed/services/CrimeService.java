/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.repositories.CrimeRepository;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Persistence;

/**
 *
 * @author JVDBG19
 */
public class CrimeService {
@Inject
    private CrimeRepository crimeRepository;
    
    public CrimeService() {
    }
    
    public List<Crime> findAll(){
        return crimeRepository.findAll();
    }

    
}
