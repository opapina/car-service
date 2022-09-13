package com.solvd.carservice.service;

import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.ServiceWorkTime;

public class ElectricalMaintenance {

    private Long id;
    private String partOfElectrical;
    private String reason;
    private ServiceWorkTime serviceWorkTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ServiceWorkTime getWorkedTime() {
        return serviceWorkTime;
    }

    public void setWorkedTime(ServiceWorkTime serviceWorkTime) {
        this.serviceWorkTime = serviceWorkTime;
    }
}
