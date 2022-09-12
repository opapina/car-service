package com.solvd.carservice.service;

import com.solvd.carservice.equipment.Material;
import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.WorkedTime;

public class SuspensionMaintenance {

    private Long id;
    private Car car;
    private String reason;
    private WorkedTime workedTime;
    private Material material;

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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
