package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.domain.Prisoner;

public class FightCreator{
    
    private PrisonerHandler prisonerHandler;


    public FightCreator(PrisonerHandler prisonerHandler) {
        this.prisonerHandler = prisonerHandler;
    }
    
    public void startFight(Guard g, Prisoner p1, Prisoner p2){
        resolveFight(g, p1, p2);
    }
    
    public void resolveFight(Guard g, Prisoner p1, Prisoner p2){
        prisonerHandler.sendToIsolation(p1);
        prisonerHandler.sendToIsolation(p2);
        
    } 
}
