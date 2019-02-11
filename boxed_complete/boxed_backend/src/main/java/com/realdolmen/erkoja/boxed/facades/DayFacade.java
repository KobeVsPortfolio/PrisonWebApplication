package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.dtos.DayDto;
import com.realdolmen.erkoja.boxed.mappers.DayMapper;
import com.realdolmen.erkoja.boxed.services.DayService;
import java.io.Serializable;
import javax.inject.Inject;

public class DayFacade implements Serializable{

    public DayFacade() {
    }
    
    @Inject
    private DayService dayService;
    @Inject
    private DayMapper dayMapper;
    
    public DayDto getCurrentDay(){
        return dayMapper.apply(dayService.getCurrentDay());
    }
}
