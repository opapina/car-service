package com.solvd.carservice.client;

import com.solvd.carservice.price.DiscountProgram;
import com.solvd.carservice.vehicle.Car;

import java.time.LocalDate;
import java.util.List;

public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Car car;
    private LocalDate registrationDate;
    private List<String> performedServices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<String> getPerformedServices() {
        return performedServices;
    }

    public void setPerformedServices(List<String> performedServices) {
        this.performedServices = performedServices;
    }
}
