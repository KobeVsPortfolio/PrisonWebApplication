
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrisonerMapperTest {
    
   @Test
   public void prisonerDtoEqualsprisonerTest(){
       Prisoner prisoner = new Prisoner();
       Cell cell = new Cell();
       cell.setCellNr("A20");
       prisoner.setCell(cell);
       List<Crime> crimes = new ArrayList<>();
       Crime crime = new Crime();
       crime.setName("Theft");
       crimes.add(crime);
       prisoner.setCrimes(crimes);
       prisoner.setId(5);
       prisoner.setIsolated(Boolean.TRUE);
       prisoner.setIsolationDuration(60);
       Job job = new Job();
       job.setName("Cleaning");
       prisoner.setJob(job);
       prisoner.setJobDuration(60);
       prisoner.setName("John");
       prisoner.setReleaseDate(100);
       PrisonerMapper prisonerM = new PrisonerMapper();
       PrisonerDto prisonerDto = prisonerM.apply(prisoner);
       assertEquals(prisonerDto.getCell().getCellNr(),prisoner.getCell().getCellNr());
       assertEquals(prisonerDto.getCrimes().get(0).getName(),prisoner.getCrimes().get(0).getName());
       assertEquals(prisonerDto.getId(),prisoner.getId());
       assertEquals(prisonerDto.getIsolated(),prisoner.getIsolated());
       assertEquals(prisonerDto.getIsolationDuration(),prisoner.getIsolationDuration());
       assertEquals(prisonerDto.getJob().getName(),prisoner.getJob().getName());
       assertEquals(prisonerDto.getJobDuration(),prisoner.getJobDuration());
       assertEquals(prisonerDto.getName(),prisoner.getName());
       assertEquals(prisonerDto.getReleaseDate(),prisoner.getReleaseDate());
       
   }
    
}
