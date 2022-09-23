package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.CarService;

import java.util.ArrayList;
import java.util.List;

public interface CarServiceRepository {

    void create(CarService carService);

    default List<CarService> findAll() {
        List<CarService> carServices = new ArrayList<>();
        return carServices;
    }

}
