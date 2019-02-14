package controllers;

import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.facades.PrisonFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ApplicationScoped
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
        cellBlocks = cellBlockFacade.findAllCellBlocks();
    }

    public void toggleDayGeneration(){
        prisonFacade.toggleTime(generating);
    }

    public List<CellBlockDto> getCellBlocks() {
        return cellBlocks;
    }

    public void setCellBlocks(List<CellBlockDto> cellBlocks) {
        this.cellBlocks = cellBlocks;
    }

    public PrisonFacade getPrisonFacade() {
        return prisonFacade;
    }

    public void setPrisonFacade(PrisonFacade prisonFacade) {
        this.prisonFacade = prisonFacade;
    }

    public CellBlockFacade getCellBlockFacade() {
        return cellBlockFacade;
    }

    public void setCellBlockFacade(CellBlockFacade cellBlockFacade) {
        this.cellBlockFacade = cellBlockFacade;
    }

    public boolean isGenerating() {
        return generating;
    }

    public void setGenerating(boolean generating) {
        this.generating = generating;
    }

}
