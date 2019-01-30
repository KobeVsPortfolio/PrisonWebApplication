package domain;

public class Guard extends Person{

    private CellBlock cellBlock;
    
    public Guard() {
    }

    public CellBlock getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlock cellBlock) {
        this.cellBlock = cellBlock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
