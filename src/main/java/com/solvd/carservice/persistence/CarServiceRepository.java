package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.CarService;

import java.util.List;

public interface CarServiceRepository {

    void create(CarService carService);

    void update(String name, Long id);

    List<CarService> findByName(String name);

    void delete(Long id);

   List<CarService> findAllLeft();

}
