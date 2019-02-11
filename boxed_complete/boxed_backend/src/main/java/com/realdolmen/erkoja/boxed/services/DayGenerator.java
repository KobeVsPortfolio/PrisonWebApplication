package com.realdolmen.erkoja.boxed.services;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.persistence.EntityManager;

public class DayGenerator implements Serializable{
    
    private DayService dayService;
    private TimerTask repeatedTask;

    public DayGenerator() {
        this.dayService = new DayService();
    }
    
    
    public DayGenerator(DayService dayService) {
        this.dayService = dayService;
    }
    
    
    
    public void generateDays(){
        repeatedTask = new TimerTask() {
        @Override
        public void run() {
            dayService.newDay();
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
