package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.repositories.DayRepository;
import java.util.List;
import javax.persistence.Persistence;

public class DayService{

    private DayRepository dayRepository;
    private PrisonerHandler prisonerHandler;

    public DayService() {
        dayRepository = new DayRepository(Persistence.createEntityManagerFactory("BoxedPersistenceUnit").createEntityManager());
    }
    
    public DayService(DayRepository dayRepository, PrisonerHandler prisonerHandler){
        this.dayRepository = dayRepository;
        this.prisonerHandler = prisonerHandler;
    }
    
    public Day getCurrentDay(){
        Day currentDay = dayRepository.findHighestValue();
        return currentDay;
        
    }
    
    public void newDay(){
        dayRepository.save(new Day());
        prisonerHandler.setCurrentDay(dayRepository.findHighestValue());
        dayProcedures();
    }
    
    public void dayProcedures(){
        prisonerHandler.handlePrisoners();
    }
}
