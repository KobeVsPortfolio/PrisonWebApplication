/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.services;


import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.repositories.CellBlockRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellBlockServiceTest {
    
    @Mock
    private CellBlockRepository cellBlockRepository;
    
    @InjectMocks
    private CellBlockService cellBlockService;

    @Test
    public void testFindAll() {
        when(cellBlockRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new CellBlock())));
        cellBlockService.findAll();
        verify(cellBlockRepository, times(1)).findAll();
    }
    
}
