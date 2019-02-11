/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdolmen.erkoja.boxed.domain.dtos;

import java.util.List;

/**
 *
 * @author JVDBG19
 */
public class PrisonerDto {
    private Boolean isolated;
    private Integer isolationDuration;
    private JobDto job;
    private List<CrimeDto> crimes;
    private Integer releaseDate;
    private CellDto cell;
    private Integer jobDuration;

    public PrisonerDto(Boolean isolated, Integer isolationDuration, JobDto job, List<CrimeDto> crimes, Integer releaseDate, CellDto cell, Integer jobDuration) {
        this.isolated = isolated;
        this.isolationDuration = isolationDuration;
        this.job = job;
        this.crimes = crimes;
        this.releaseDate = releaseDate;
        this.cell = cell;
        this.jobDuration = jobDuration;
    }

    public Boolean getIsolated() {
        return isolated;
    }

    public void setIsolated(Boolean isolated) {
        this.isolated = isolated;
    }

    public Integer getIsolationDuration() {
        return isolationDuration;
    }

    public void setIsolationDuration(Integer isolationDuration) {
        this.isolationDuration = isolationDuration;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    public List<CrimeDto> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<CrimeDto> crimes) {
        this.crimes = crimes;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CellDto getCell() {
        return cell;
    }

    public void setCell(CellDto cell) {
        this.cell = cell;
    }

    public Integer getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(Integer jobDuration) {
        this.jobDuration = jobDuration;
    }
    
}
