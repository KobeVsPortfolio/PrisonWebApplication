package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.services.DayGenerator;

public class PrisonFacade{
    
    private DayGenerator dayGenerator;
    
    
    public boolean toggleTime(boolean timeOn){
        dayGenerator = new DayGenerator();
        if(timeOn == true ){
            dayGenerator.stopCounting();
            return false;
        } else{
            dayGenerator.generateDays();
            return true;
        }
    }
    
    
}