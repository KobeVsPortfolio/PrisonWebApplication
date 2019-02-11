/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.repositories.JobRepository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author JVDBG19
 */
public class JobService {
    @Inject
    private JobRepository jobRepository;
    
    public JobService() {
    }
    
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

}
