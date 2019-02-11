/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.domain.dtos;

/**
 *
 * @author JVDBG19
 */
public class CrimeDto {
    private Integer id;
    private String name;
    private Integer punishment;

    public CrimeDto(Integer id, String name, Integer punishment) {
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
