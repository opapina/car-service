package com.solvd.carservice.domain.vehicle;

import com.solvd.carservice.domain.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class Car {

    private static final Logger LOGGER = LogManager.getLogger(Car.class);

    public void move() {
        LOGGER.info("Car moves straight along");
    }

    private String model;
    private String brand;
    private LocalDate yearCreate;
    private String vinCode;
    private List<Service> services;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getYearCreate() {
        return yearCreate;
    }

    public void setYearCreate(LocalDate yearCreate) {
        this.yearCreate = yearCreate;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", yearCreate=" + yearCreate +
                ", vinCode='" + vinCode + '\'' +
                ", services=" + services +
                '}';
    }
}
