
package com.realdolmen.erkoja.boxed.dtos;

import com.realdolmen.erkoja.boxed.domain.Grade;

public class GuardDto {
    private Integer id;
    private String name;
    private CellBlockDto cellBlock;
    private Grade grade;

    public GuardDto(Integer id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public CellBlockDto getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlockDto cellBlock) {
        this.cellBlock = cellBlock;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
