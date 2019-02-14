
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

public class PrisonerDTOMapper implements Function<PrisonerDto, Prisoner> {

    @Override
    public Prisoner apply(PrisonerDto p) {
        Prisoner prisoner = new Prisoner(p.getIsolated(), p.getIsolationDuration(), p.getReleaseDate(), p.getJobDuration());
        
        if(p.getId()!=null){
            Integer id = p.getId();
            prisoner.setId(id);
        }
        
        if(p.getName()!=null){
            String name = p.getName();
            prisoner.setName(name);
        }
        
        if(p.getCrimes()!=null){
            CrimeDTOMapper cm = new CrimeDTOMapper();
            List<CrimeDto> crimeDtos = p.getCrimes();
            List<Crime> crimes = new ArrayList<>();
            for(CrimeDto c : crimeDtos){
                crimes.add(cm.apply(c));
            }
            prisoner.setCrimes(crimes);
        }
        
        if(p.getCell()!=null){
            CellDTOMapper cm = new CellDTOMapper();
            CellDto c = p.getCell();
            Cell cell = cm.apply(c);
            prisoner.setCell(cell);
        }
        
        if(p.getJob()!=null){
            JobDTOMapper jm = new JobDTOMapper();
            JobDto j = p.getJob();
            Job job = jm.apply(j);
            prisoner.setJob(job);
        }
        
        return prisoner;
        
    }
   
} 