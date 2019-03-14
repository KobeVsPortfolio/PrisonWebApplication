package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.repositories.DayRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Persistence;

public class DayService implements Serializable{
    
    @Inject
    private DayRepository dayRepository;
    
    public DayService() {
    }
    
    public DayService(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }
    
    public Day getCurrentDay(){
        Day currentDay = dayRepository.findHighestValue();
        return currentDay;
        
    }
    
    public void newDay(){
        dayRepository.save(new Day());
    }
}
