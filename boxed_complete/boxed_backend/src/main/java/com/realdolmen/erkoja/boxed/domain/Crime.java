package com.realdolmen.erkoja.boxed.domain;

import javax.persistence.*;

@Entity
@Table(name = "Crime")
public class Crime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
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
