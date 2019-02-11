
package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Grade;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GuardMapperTest {
    
    @Test
    public void GuardDtoEqalsGuardtest(){
        Guard guard = new Guard();
        CellBlock cellBlock = new CellBlock();
        cellBlock.setCellBlockId("A");
        guard.setCellBlock(cellBlock);
        guard.setGrade(Grade.WARDEN);
        guard.setId(5);
        guard.setName("Jos");
        GuardMapper guardM = new GuardMapper();
        GuardDto guardDto = guardM.apply(guard);
        assertEquals(guardDto.getCellBlock().getCellBlockId(),guard.getCellBlock().getCellBlockId());
        assertEquals(guardDto.getGrade(),guard.getGrade());
        assertEquals(guardDto.getId(),guard.getId());
        assertEquals(guardDto.getName(),guard.getName());
    }
    
    
}
