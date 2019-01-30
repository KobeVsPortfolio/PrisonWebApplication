package controllers;

import domain.CellBlock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class PrisonController implements Serializable{
    
    private List<CellBlock> cellBlocks;
    
    @PostConstruct
    public void init(){
        cellBlocks = new ArrayList<>();
        CellBlock a = new CellBlock();
        CellBlock b = new CellBlock();
        CellBlock c = new CellBlock();
        CellBlock d = new CellBlock();
        a.setCellBlockId("A");
        b.setCellBlockId("B");
        c.setCellBlockId("C");
        d.setCellBlockId("D");
        cellBlocks.add(a);
        cellBlocks.add(b);
        cellBlocks.add(c);
        cellBlocks.add(d);
    }

    public List<CellBlock> getCellBlocks() {
        return cellBlocks;
    }

    public void setCellBlocks(List<CellBlock> cellBlocks) {
        this.cellBlocks = cellBlocks;
    } 
}