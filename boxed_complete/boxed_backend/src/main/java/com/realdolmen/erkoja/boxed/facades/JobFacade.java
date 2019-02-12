
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.mappers.JobMapper;
import com.realdolmen.erkoja.boxed.services.JobService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


public class JobFacade implements Serializable{
     @Inject
    private JobService jobService;

    public JobFacade() {
    }
  
    public List<JobDto> findAll() {
        List<Job> jobs = jobService.findAll();
        return jobs.stream()
                .map(cell -> new JobMapper().apply(cell))
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .collect(Collectors.toList());
    } 
}
