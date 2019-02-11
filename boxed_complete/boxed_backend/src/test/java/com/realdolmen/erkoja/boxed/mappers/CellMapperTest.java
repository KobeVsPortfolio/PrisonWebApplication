/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.repositories.CellRepository;
import java.util.ArrayList;
import java.util.List;
import org.jboss.com.sun.org.omg.CORBA.Repository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JVDBG19
 */
public class CellMapperTest {
    
    @Test
    public void CellDtoEqualsCellTest(){
        Cell cell = new Cell();
        cell.setCellId(15);
        cell.setSize(2);
        cell.setCellNr("A15");
        List<Prisoner> prisoners = new ArrayList<>();
        Prisoner prisoner = new Prisoner();
        prisoner.setId(5);
        prisoners.add(prisoner);
        cell.setPrisonerList(prisoners);
        CellBlock cellB = new CellBlock();
        cellB.setCellBlockId("A");
        cell.setCellBlock(cellB);
        CellMapper cellM = new CellMapper();
        CellDto cellDto = cellM.apply(cell);
        assertEquals(cellDto.getCellBlock().getCellBlockId(), cell.getCellBlock().getCellBlockId());
        assertEquals(cellDto.getCellId(),cell.getCellId());
        assertEquals(cellDto.getSize(),cell.getSize());
        assertEquals(cellDto.getCellNr(),cell.getCellNr());
        assertEquals(cellDto.getPrisonerList().get(0).getId(),cell.getPrisonerList().get(0).getId());
    }
}
