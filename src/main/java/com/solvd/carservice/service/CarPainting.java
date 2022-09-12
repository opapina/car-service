package com.solvd.carservice.service;

import com.solvd.carservice.vehicle.Car;
import com.solvd.carservice.worktime.WorkedTime;

public class CarPainting {

    private Long id;
    private Car car;
    private String partOfCarBody;
    private Integer countOfLayers;
    private String colorPainting;
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

    public WorkedTime getWorkedTime() {
        return workedTime;
    }

    public void setWorkedTime(WorkedTime workedTime) {
        this.workedTime = workedTime;
    }
}
