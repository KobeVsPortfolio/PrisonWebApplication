
package com.realdolmen.erkoja.boxed.domain;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@MappedSuperclass
public abstract class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id; 
    protected String name;

    public Person() {
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
