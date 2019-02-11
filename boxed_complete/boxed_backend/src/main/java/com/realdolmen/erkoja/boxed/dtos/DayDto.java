/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.dtos;

/**
 *
 * @author JVDBG19
 */
public class DayDto {
    private Integer dayNr;

    public DayDto(Integer dayNr) {
        this.dayNr = dayNr;
    }

    public Integer getDayNr() {
        return dayNr;
    }

    public void setDayNr(Integer dayNr) {
        this.dayNr = dayNr;
    }
    
}
