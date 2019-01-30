package com.realdolmen.erkoja.boxed.services;

import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FightCreatorTest {
    
    
    FightCreator fightCreator;
    Prisoner p1;
    Prisoner p2;
    Guard g;
    
    @Mock
    PrisonerHandler prisonerHandler;
    
    @Before
    public void init(){
        fightCreator = new FightCreator(prisonerHandler);
        p1 = new Prisoner();
        p2 = new Prisoner();
        g = new Guard();
        p1.setName("Fighter1");
        p2.setName("Fighter2");
        g.setName("Guard");
    }
    
    @Test
    public void resolveFightTest() {
        
        fightCreator.resolveFight(g, p1, p2);
        
        verify(prisonerHandler, times(1)).sendToIsolation(p1);
        verify(prisonerHandler, times(1)).sendToIsolation(p2);
        
    }
    
}
