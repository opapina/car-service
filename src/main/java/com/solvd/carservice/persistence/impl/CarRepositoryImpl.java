package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.service.Service;
import com.solvd.carservice.domain.vehicle.Car;
import com.solvd.carservice.persistence.CarRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    @Override
    public void create(Car car) {

    }

    public static List<Car> mapCar(ResultSet resultSet, List<Car> cars) throws SQLException {
        long id = resultSet.getLong("car_id");
        if (id != 0) {
            if (cars == null) {
                cars = new ArrayList<>();
            }

            Car car = findById(id, cars);
            car.setModel(resultSet.getString("model"));
            car.setBrand(resultSet.getString("brand"));
            car.setYearCreate(resultSet.getTimestamp("year_create").toLocalDateTime().toLocalDate());
            car.setVinCode(resultSet.getString("vin_code"));

            List<Service> services = ServiceRepositoryImpl.mapSrvice(resultSet, car.getServices());
            car.setServices(services);
        }
        return cars;
    }
}
