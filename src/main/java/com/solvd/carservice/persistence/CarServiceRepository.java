package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.CarService;

import java.util.ArrayList;
import java.util.List;

public interface CarServiceRepository {

    void create(CarService carService);

    default List<CarService> findAllLeft() {
        List<CarService> carServices = new ArrayList<>();
        return carServices;
    }

    default List<CarService> findAllRight() {
        List<CarService> carServices = new ArrayList<>();
        return carServices;
    }

}
