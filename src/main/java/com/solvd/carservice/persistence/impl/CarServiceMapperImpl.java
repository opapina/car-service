package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.persistence.CarServiceRepository;
import com.solvd.carservice.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CarServiceMapperImpl implements CarServiceRepository {

    @Override
    public void create(CarService carService) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            CarServiceRepository carServiceRepository = session.getMapper(CarServiceRepository.class);
            carServiceRepository.create(carService);
        }
    }

    @Override
    public void update(String name, Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            CarServiceRepository carServiceRepository = session.getMapper(CarServiceRepository.class);
            carServiceRepository.update(name, id);
        }
    }

    @Override
    public List<CarService> findByName(String name) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            CarServiceRepository carServiceRepository = session.getMapper(CarServiceRepository.class);
            return carServiceRepository.findByName(name);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            CarServiceRepository carServiceRepository = session.getMapper(CarServiceRepository.class);
            carServiceRepository.delete(id);
        }
    }

    @Override
    public List<CarService> findAllLeft() {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            CarServiceRepository carServiceRepository = session.getMapper(CarServiceRepository.class);
            return carServiceRepository.findAllLeft();
        }
    }
}
