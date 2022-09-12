package com.solvd.carservice.service;

import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.WorkedTime;

public class ElectricalMaintenance {

    private Long id;
    private Car car;
    private String partOfElectrical;
    private String reason;
    private WorkedTime workedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getPartOfElectrical() {
        return partOfElectrical;
    }

    public void setPartOfElectrical(String partOfElectrical) {
        this.partOfElectrical = partOfElectrical;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public WorkedTime getWorkedTime() {
        return workedTime;
    }

    public void setWorkedTime(WorkedTime workedTime) {
        this.workedTime = workedTime;
    }
}
