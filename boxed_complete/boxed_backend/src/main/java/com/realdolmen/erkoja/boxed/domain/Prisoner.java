package com.realdolmen.erkoja.boxed.domain;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NamedQueries({
@NamedQuery(name=Prisoner.FIND_TORELEASE, query="select p from Prisoner p where p.releaseDate <= :currentDate"),
@NamedQuery(name=Prisoner.FIND_JOBS, query="select p from Prisoner p where p.jobDuration <= :currentDate AND p.job IS NOT NULL"),
@NamedQuery(name=Prisoner.FIND_INISOLATION, query="select p from Prisoner p where p.isolated = true AND p.isolationDuration <= :currentDate")})
@Table(name = "Prisoner")
public class Prisoner extends Person {
    public static final String FIND_TORELEASE = "findToRelease";
    public static final String FIND_INISOLATION = "findInIsolation";
    public static final String FIND_JOBS = "findPrisonersWithJob";
    
    private Boolean isolated;
    private Integer isolationDuration;
    
    @OneToOne
    private Job job;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @Column(nullable = false)
    private List<Crime> crimes;
    
    @Column(nullable = false)
    private Integer releaseDate;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Cell cell;
    
    private Integer jobDuration;

    public Prisoner() {
    }    

    public Prisoner(Boolean isolated, Integer isolationDuration, Integer releaseDate, Integer jobDuration) {
        this.isolated = isolated;
        this.isolationDuration = isolationDuration;
        this.releaseDate = releaseDate;
        this.jobDuration = jobDuration;
    }
    
    public void fight(Prisoner p) {

    }

    public void finishJob(Job job) {

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
}
