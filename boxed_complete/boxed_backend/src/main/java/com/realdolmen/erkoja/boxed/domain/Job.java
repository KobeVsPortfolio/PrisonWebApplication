package com.realdolmen.erkoja.boxed.domain;

import javax.persistence.*;

@Entity
@Table(name = "Job")
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Integer duration;

    public Job() {
    }

    public Job(Integer id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    
    
}
