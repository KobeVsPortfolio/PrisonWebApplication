
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PrisonerMapper implements Function<Prisoner,PrisonerDto> {

    @Override
    public PrisonerDto apply(Prisoner prisoner) {
        PrisonerDto dto = new PrisonerDto(prisoner.getId(), prisoner.getName(), prisoner.getIsolated(),prisoner.getIsolationDuration(), prisoner.getReleaseDate(), prisoner.getJobDuration());
        if(prisoner.getJob()!=null){
            Job job = prisoner.getJob();
            dto.setJob(new JobDto(job.getId(), job.getName(), job.getDuration()));
        }
        if(prisoner.getCrimes()!= null){
            CrimeMapper cm = new CrimeMapper();
            List<Crime> crimeList = prisoner.getCrimes();
            List<CrimeDto> crimeDtoList = new ArrayList<>();
            for(Crime c : crimeList){
                crimeDtoList.add(cm.apply(c));
            }
            dto.setCrimes(crimeDtoList);
        }
        if(prisoner.getCell() != null){
            CellMapper cm = new CellMapper();
            Cell cell = prisoner.getCell();
            CellDto cellDto = cm.apply(cell);
            dto.setCell(cellDto);
        }
        return dto;
    }
} 

