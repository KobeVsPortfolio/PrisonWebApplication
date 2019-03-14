package com.realdolmen.erkoja.boxed.facades;

import com.realdolmen.erkoja.boxed.services.DayGenerator;
import java.io.Serializable;
import javax.inject.Inject;

public class PrisonFacade implements Serializable {

    public PrisonFacade() {
    }

    @Inject
    private DayGenerator dayGenerator;

    public boolean toggleTime(boolean timeOn) {
        if (timeOn == true) {
            dayGenerator.stopCounting();
            return false;
        } else {
            dayGenerator.generateDays();
            return true;
        }
    }
    
    public void generateDays(){
        dayGenerator.generateDays();   
    }
    
    public void stopGenerating(){
        dayGenerator.stopCounting();
    }

}
