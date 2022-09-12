package com.solvd.carservice.service;

import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.WorkedTime;

public class EngineMaintenance {

    private Long id;
    private Car car;
    private Double volumeEngine;
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

    public Double getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(Double volumeEngine) {
        this.volumeEngine = volumeEngine;
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
