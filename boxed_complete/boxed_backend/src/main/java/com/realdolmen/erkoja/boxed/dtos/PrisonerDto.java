
package com.realdolmen.erkoja.boxed.dtos;

import java.util.List;

public class PrisonerDto {
    private Integer id;
    private String name;
    private Boolean isolated;
    private Integer isolationDuration;
    private JobDto job;
    private List<CrimeDto> crimes;
    private Integer releaseDate;
    private CellDto cell;
    private Integer jobDuration;

    public PrisonerDto() {
    }
    
    public PrisonerDto(Integer id, String name, Boolean isolated, Integer isolationDuration, Integer releaseDate, Integer jobDuration) {
        this.id = id;
        this.name = name;
        this.isolated = isolated;
        this.isolationDuration = isolationDuration;
        this.job = job;
        this.crimes = crimes;
        this.releaseDate = releaseDate;
        this.cell = cell;
        this.jobDuration = jobDuration;
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
