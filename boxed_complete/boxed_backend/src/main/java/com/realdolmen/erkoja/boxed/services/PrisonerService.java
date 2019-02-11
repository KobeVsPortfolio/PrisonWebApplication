/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.repositories.PrisonerRepository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author JVDBG19
 */
public class PrisonerService {
        @Inject
    private PrisonerRepository prisonerRepository;
    
    public PrisonerService() {
    }
    
    public List<Prisoner> findAll(){
        return prisonerRepository.findAll();
    }

}
