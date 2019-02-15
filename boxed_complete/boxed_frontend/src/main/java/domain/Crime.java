package domain;

public class Crime {
    
    private Integer id;
    private String name;
    private Integer punishment;

    public Crime() {
    }

    public Crime(Integer id, String name, Integer punishment) {
        this.id = id;
        this.name = name;
        this.punishment = punishment;
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

    public Integer getPunishment() {
        return punishment;
    }

    public void setPunishment(Integer punishment) {
        this.punishment = punishment;
    }

    
}
