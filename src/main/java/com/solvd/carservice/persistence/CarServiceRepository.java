package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.CarService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarServiceRepository {

    void create(CarService carService);

    void update(@Param("name") String name, @Param("id") Long id);

    List<CarService> findByName(String name);

    void delete(Long id);

    List<CarService> findAllLeft();

    List<CarService> findById(Long id);

}
