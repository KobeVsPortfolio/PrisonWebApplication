
package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.mappers.JobMapper;
import com.realdolmen.erkoja.boxed.services.JobService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class JobFacadeTest {
    @Mock
     private JobService jobService;
    @Mock
    private JobMapper jobMapper;
    @InjectMocks
    private JobFacade jobFacade;

    @Test
    public void FindAllJobandAddJobTestDto(){
        List<Job> jobs = new ArrayList<>();
        Job job = new Job();
        job.setId(9);
        jobs.add(job);
        List<JobDto> result = jobFacade.findAll();
        when(jobService.findAll()).thenReturn(jobs);
        assertNotNull(result);
    }
    
   
    
}
