package com.solvd.carservice.service;

import com.solvd.carservice.domain.CarService;

import java.util.List;

public interface CarServiceService {

    CarService create(CarService carService);

    List<CarService> retrieveAll();
}
