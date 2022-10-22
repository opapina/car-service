package com.solvd.carservice.service;

import com.solvd.carservice.domain.CarService;

import java.util.List;

public interface CarServiceService {

    CarService create(CarService carService);

    CarService update(CarService carservice, String name);

    void deleteById(Long id);

    List<CarService> selectByName(String name);

    List<CarService> retrieveAll();

    List<CarService> selectById(Long id);

}
