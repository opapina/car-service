package com.solvd.carservice.service;

import com.solvd.carservice.domain.vehicle.Car;

public interface CarService {

   Car create(Car car, Long id);
}
