package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.dtos.DayDto;
import java.util.function.Function;

public class DayMapper implements Function<Day, DayDto>{

    @Override
    public DayDto apply(Day day) {
        DayDto dto = new DayDto(day.getDayNr());
        return dto;
    }
    
}
