
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import java.util.function.Function;

public class JobDTOMapper implements Function<JobDto,Job> {

    @Override
    public Job apply(JobDto j) {
        Job job = new Job(j.getId(), j.getName(), j.getDuration());
        return job;
    }
} 
