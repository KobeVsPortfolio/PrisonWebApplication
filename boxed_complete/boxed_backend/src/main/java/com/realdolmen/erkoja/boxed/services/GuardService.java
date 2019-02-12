/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.repositories.GuardRepository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author JVDBG19
 */
public class GuardService {
    @Inject
    private GuardRepository guardRepository;
    
    public GuardService() {
    }
    
    public List<Guard> findAll(){
        return guardRepository.findAll();
    }
}
