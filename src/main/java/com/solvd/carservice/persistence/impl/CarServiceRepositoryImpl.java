package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.persistence.CarServiceRepository;

import java.util.List;

public class CarServiceRepositoryImpl implements CarServiceRepository {
    @Override
    public void create(CarService carService) {

    }

    @Override
    public List<CarService> findAll() {
        return CarServiceRepository.super.findAll();
    }
}
