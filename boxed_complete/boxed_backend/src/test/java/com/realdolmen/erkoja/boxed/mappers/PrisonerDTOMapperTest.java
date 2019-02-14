
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrisonerDTOMapperTest {
    
    public PrisonerDTOMapperTest() {
    }

    @Test
    public void PrisonerDTOMappedToPrisonerTest() {
        
       PrisonerDto pDto = new PrisonerDto(1, "Bob", false, 50, 5000, 300);
       CellDto cDto = new CellDto(5, "A5", 2, false);
       pDto.setCell(cDto);
       List<CrimeDto> crimeDtos = new ArrayList<>();
       CrimeDto crimeDto = new CrimeDto(3, "Moord", 1000);
       crimeDtos.add(crimeDto);
       pDto.setCrimes(crimeDtos);
       JobDto jDto = new JobDto(4, "Kitchen", 100);
       pDto.setJob(jDto);
       PrisonerDTOMapper mapper = new PrisonerDTOMapper();
       Prisoner prisoner = mapper.apply(pDto);
       assertEquals(pDto.getCell().getCellNr(),prisoner.getCell().getCellNr());
       assertEquals(pDto.getCrimes().get(0).getName(),prisoner.getCrimes().get(0).getName());
       assertEquals(pDto.getId(),prisoner.getId());
       assertEquals(pDto.getIsolated(),prisoner.getIsolated());
       assertEquals(pDto.getIsolationDuration(),prisoner.getIsolationDuration());
       assertEquals(pDto.getJob().getName(),prisoner.getJob().getName());
       assertEquals(pDto.getJobDuration(),prisoner.getJobDuration());
       assertEquals(pDto.getName(),prisoner.getName());
       assertEquals(pDto.getReleaseDate(),prisoner.getReleaseDate());
       
   }
    }
   
