
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import java.util.function.Function;

public class CrimeMapper implements Function<Crime,CrimeDto> {

    @Override
    public CrimeDto apply(Crime crime) {
        CrimeDto dto = new CrimeDto(crime.getId(), crime.getName(), crime.getPunishment());
        return dto;
    }
} 
