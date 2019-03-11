package com.realdolmen.erkoja.boxed.services;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DayGenerator implements Serializable{
    
    @Inject
    private DayService dayService;
    
    @Inject
    private PrisonerHandler prisonerHandler;
    
    private TimerTask repeatedTask;

    public DayGenerator() {
    }
        
    public void generateDays(){
        repeatedTask = new TimerTask() {
        @Override
        public void run() {
            dayService.newDay();
            prisonerHandler.handlePrisoners();
        }
    };
    Timer timer = new Timer("Timer");
     
    long delay  = 5000L;
    long period = 5000L;
    timer.scheduleAtFixedRate(repeatedTask, delay, period);
        
    }
 
    public void stopCounting(){
        repeatedTask.cancel();
    }
    
    
}
