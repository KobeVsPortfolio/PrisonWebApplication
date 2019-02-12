package controllers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class PrisonController implements Serializable{
    
    private List<CellBlock> cellBlocks;
    
    @Inject
    private PrisonFacade prisonFacade;
    @Inject
    private CellBlockFacade cellBlockFacade;
    
    private boolean generating;
    
    
    
    @PostConstruct
    public void init(){
        generating = false;
        cellBlocks = cellBlockFacade.findAllTest();
    }

    public void toggleDayGeneration(){
        prisonFacade.toggleTime(generating);
        generating = (generating == false)?true:false;
    }

    public List<CellBlock> getCellBlocks() {
        return cellBlocks;
    }

    public void setCellBlocks(List<CellBlock> cellBlocks) {
        this.cellBlocks = cellBlocks;
    }

    
    
    
    


}