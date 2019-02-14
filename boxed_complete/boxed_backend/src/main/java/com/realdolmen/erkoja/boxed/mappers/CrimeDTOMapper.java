
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import java.util.function.Function;

public class CrimeDTOMapper implements Function<CrimeDto,Crime> {

    @Override
    public Crime apply(CrimeDto c) {
        Crime crime = new Crime(c.getId(), c.getName(), c.getPunishment());
        return crime;
    }
} 
