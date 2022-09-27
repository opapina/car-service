package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.CarService;

import java.util.ArrayList;
import java.util.List;

public interface CarServiceRepository {

    void create(CarService carService);

    void update(String name, Long id);

    default List<CarService> findByName (String name) {
        List<CarService> carServices = new ArrayList<>();
        return carServices;
    }

    void delete(Long id);

    default List<CarService> findAllLeft() {
        List<CarService> carServices = new ArrayList<>();
        return carServices;
    }
}
