
package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.repositories.JobRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class JobService implements Serializable{
    
    @Inject
    private JobRepository jobRepository;
    
    public JobService() {
    }
    
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

}
