package com.realdolmen.erkoja.boxed.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
@NamedQuery(name=Prisoner.FIND_TORELEASE, query="select p from Prisoner p where releaseDate <= :currentDate"),
@NamedQuery(name=Prisoner.FIND_JOBS, query="select p from Prisoner p where jobDuration <= :currentDate"),
@NamedQuery(name=Prisoner.FIND_INISOLATION, query="select p from Prisoner p where isolated <= :currentDate")})
@Table(name = "Prisoner")
public class Prisoner extends Person {
    public static final String FIND_TORELEASE = "findToRelease";
    public static final String FIND_INISOLATION = "findInIsolation";
    public static final String FIND_JOBS = "findPrisonersWithJob";
    
    private Integer isolated;
    
    @OneToOne
    private Job job;
    
    @OneToMany
    @Column(nullable = false)
    private List<Crime> crimes;
    
    @Column(nullable = false)
    private Integer releaseDate;
    
    @ManyToOne
    private Cell cell;
    private Integer jobDuration;

    public Prisoner() {
    }

    public void fight(Prisoner p) {

    }

    public void finishJob(Job job) {

    }
    
    public Integer getIsolated() {
        return isolated;
    }

    public void setIsolated(Integer isolated) {
        this.isolated = isolated;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Integer getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(Integer jobDuration) {
        this.jobDuration = jobDuration;
    }

}
