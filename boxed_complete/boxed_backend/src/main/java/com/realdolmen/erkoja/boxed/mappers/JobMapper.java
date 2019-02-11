
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import java.util.List;
import java.util.function.Function;

public class JobMapper implements Function<Job,JobDto> {

    @Override
    public JobDto apply(Job job) {
        JobDto dto = new JobDto(job.getId(), job.getName(), job.getDuration());
        return dto;
    }
} 
