package com.solvd.carservice.service;

import com.solvd.carservice.equipment.Material;
import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.ServiceWorkTime;

public class SuspensionMaintenance {

    private Long id;
    private String reason;
    private ServiceWorkTime serviceWorkTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ServiceWorkTime getWorkedTime() {
        return serviceWorkTime;
    }

    public void setWorkedTime(ServiceWorkTime serviceWorkTime) {
        this.serviceWorkTime = serviceWorkTime;
    }

}
