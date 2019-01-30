package controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@Named
@ApplicationScoped
public class PersonsController implements Serializable {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String serviceLevel;

    @PostConstruct
    public void init() {
        System.out.println("In init method");
        firstName = "Steven";
        lastName = "De Cock";
        dateOfBirth = "2011-01-02";
        gender = "M";
        email = "steven.decock@realdolmen.com";
        serviceLevel = "admin";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }


}
