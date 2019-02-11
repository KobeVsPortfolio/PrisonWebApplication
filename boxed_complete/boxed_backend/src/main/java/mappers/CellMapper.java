package mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.domain.dtos.CellDto;
import java.util.function.Function;

public class CellMapper implements Function<Cell,CellDto> {

    @Override
    public CellDto apply(Cell cell) {
//        CellDto dto = new CellDto(cell.getCellId(),cell.getCellNr(),cell.getSize(),cell.isIsolationCell(),cell.getPrisonerList());
//        if(cell.getCellBlock()!=null){
//            CellBlock cellBlock = cell.getCellBlock();
//            dto.setCellBlock(new CellBlockDto(cellBlock.getCellBlockId(),cellBlock.getCells(),cellBlock.getGuards()));
//        }
//        return dto;
   return null; } 
    
    
}
