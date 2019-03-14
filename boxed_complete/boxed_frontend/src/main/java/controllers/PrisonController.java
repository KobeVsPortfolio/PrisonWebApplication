package controllers;

import com.realdolmen.erkoja.boxed.domain.Day;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.DayDto;
import com.realdolmen.erkoja.boxed.facades.CellBlockFacade;
import com.realdolmen.erkoja.boxed.facades.DayFacade;
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
    private DayDto currentDay;
    
    @Inject
    private PrisonFacade prisonFacade;
    
    @Inject
    private CellBlockFacade cellBlockFacade;
    
    @Inject
    private DayFacade dayFacade;

    @PostConstruct
    public void init(){
        cellBlocks = cellBlockFacade.findAllCellBlocks();
    }

    public void startDayGeneration(){
        prisonFacade.generateDays();
    }

    public DayDto getCurrentDay() {
        currentDay = dayFacade.getCurrentDay();
        return currentDay;
    }

    public void setCurrentDay(DayDto currentDay) {
        this.currentDay = currentDay;
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

}
