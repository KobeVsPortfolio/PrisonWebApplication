package controllers;

import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
import domain.CellBlock;
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
    
    private List<CellBlockDto> cellBlocks;
    
    @Inject
    private PrisonFacade prisonFacade;
    @Inject
    private CellBlockFacade cellBlockFacade;
    
    private boolean generating;
    
    
    
    @PostConstruct
    public void init(){
        generating = false;
        cellBlocks = cellBlockFacade.findAll();
    }

    public void toggleDayGeneration(){
        prisonFacade.toggleTime(generating);
        generating = (generating == false)?true:false;
    }

    public List<CellBlockDto> getCellBlocks() {
        return cellBlocks;
    }

    public void setCellBlocks(List<CellBlockDto> cellBlocks) {
        this.cellBlocks = cellBlocks;
    }
    
    
    


}