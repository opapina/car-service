package com.solvd.carservice.service;

import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.ServiceWorkTime;

public class CarPainting {

    private Long id;
    private String partOfCarBody;
    private Integer countOfLayers;
    private String colorPainting;
    private ServiceWorkTime serviceWorkTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartOfCarBody() {
        return partOfCarBody;
    }

    public void setPartOfCarBody(String partOfCarBody) {
        this.partOfCarBody = partOfCarBody;
    }

    public Integer getCountOfLayers() {
        return countOfLayers;
    }

    public void setCountOfLayers(Integer countOfLayers) {
        this.countOfLayers = countOfLayers;
    }

    public String getColorPainting() {
        return colorPainting;
    }

    public void setColorPainting(String colorPainting) {
        this.colorPainting = colorPainting;
    }

    public ServiceWorkTime getWorkedTime() {
        return serviceWorkTime;
    }

    public void setWorkedTime(ServiceWorkTime serviceWorkTime) {
        this.serviceWorkTime = serviceWorkTime;
    }
}
