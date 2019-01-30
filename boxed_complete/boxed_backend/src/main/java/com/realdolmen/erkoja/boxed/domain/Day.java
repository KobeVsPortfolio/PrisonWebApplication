package com.realdolmen.erkoja.boxed.domain;

import javax.persistence.*;

@Entity
@Table(name = "Day")
@NamedQuery(name = Day.FIND_LAST_ENTRY, query = "select MAX(d.dayNr) from Day d")
public class Day {
    public static final String FIND_LAST_ENTRY = "findLastEntry";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dayNr;

    public Day() {
    }
    

    public Day(Integer dayNr) {
        this.dayNr = dayNr;
    }

    public Integer getDayNr() {
        return dayNr;
    }

    public void setDayNr(Integer dayNr) {
        this.dayNr = dayNr;
    }
    
    
    
}
