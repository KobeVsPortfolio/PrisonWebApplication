
package com.realdolmen.erkoja.boxed.services;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DayGeneratorTest {

    private DayGenerator dayGenerator;
    
    @Mock
    DayService dayService;
    
    @Before
    public void init(){
        dayGenerator = new DayGenerator(dayService);
    }
    
    @Ignore
    @Test
    public void generateDaysTestGenerates2DaysAfter14Secs() throws InterruptedException{
        dayGenerator.generateDays();
        TimeUnit.SECONDS.sleep(14);
        dayGenerator.stopCounting();
        verify(dayService, times(2)).newDay();
    }
    
    @Ignore
    @Test
    public void generateDaysTestGenerates3DaysAfter15Secs() throws InterruptedException{
        dayGenerator.generateDays();
        TimeUnit.SECONDS.sleep(16);
        dayGenerator.stopCounting();
        verify(dayService, times(3)).newDay();
    }
    
    
    
}
