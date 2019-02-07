/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;



/**
 *
 * @author JVDBG19
 */
public class GuardDto {
    private CellBlockDto cellBlock;
    private GradeDto grade;

    public GuardDto(CellBlockDto cellBlock, GradeDto grade) {
        this.cellBlock = cellBlock;
        this.grade = grade;
    }

    public CellBlockDto getCellBlock() {
        return cellBlock;
    }

    public void setCellBlock(CellBlockDto cellBlock) {
        this.cellBlock = cellBlock;
    }

    public GradeDto getGrade() {
        return grade;
    }

    public void setGrade(GradeDto grade) {
        this.grade = grade;
    }
    
    
    
}
