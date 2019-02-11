/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JVDBG19
 */
public class CrimeMapperTest {
    
    @Test
    public void CrimeDtoEqualsCrimetest(){
        Crime crime = new Crime();
        crime.setName("theft");
        crime.setId(2);
        crime.setPunishment(60);
        CrimeMapper crimeM = new CrimeMapper();
        CrimeDto crimeDto = crimeM.apply(crime);
        assertEquals(crimeDto.getName(),crime.getName());
        assertEquals(crimeDto.getId(),crime.getId());
        assertEquals(crimeDto.getPunishment(),crime.getPunishment());
        
    }
    
}
