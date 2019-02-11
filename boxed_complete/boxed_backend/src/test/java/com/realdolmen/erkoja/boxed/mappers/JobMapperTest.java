
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JobMapperTest {
    
    @Test
   public void jobDtoEqualsJobTest(){
       Job job = new Job();
       job.setDuration(60);
       job.setId(5);
       job.setName("cleaning");
       JobMapper jobM = new JobMapper();
       JobDto jobDto = jobM.apply(job);
       assertEquals(jobDto.getDuration(), job.getDuration());
       assertEquals(jobDto.getId(),job.getId());
       assertEquals(jobDto.getName(),jobDto.getName());

       }
   }

