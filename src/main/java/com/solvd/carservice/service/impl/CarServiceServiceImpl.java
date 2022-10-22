package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.persistence.CarServiceRepository;
import com.solvd.carservice.persistence.impl.CarServiceMapperImpl;
import com.solvd.carservice.persistence.impl.CarServiceRepositoryImpl;
import com.solvd.carservice.service.CarServiceService;
import com.solvd.carservice.service.ClientService;
import com.solvd.carservice.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceServiceImpl implements CarServiceService {

    private final CarServiceRepository carServiceRepository;
    private final DepartmentService departmentService;
    private final ClientService clientService;

    public CarServiceServiceImpl() {
//        this.carServiceRepository = new CarServiceRepositoryImpl();
        this.carServiceRepository = new CarServiceMapperImpl();
        this.departmentService = new DepartmentServiceImpl();
        this.clientService = new ClientServiceImpl();
    }

    @Override
    public CarService create(CarService carService) {
        carService.setId(null);
        carServiceRepository.create(carService);

        if (carService.getDepartments() != null) {
            List<Department> departments = carService.getDepartments().stream()
                    .map(department -> departmentService.create(department, carService.getId()))
                    .collect(Collectors.toList());
            carService.setDepartments(departments);
        }
        if (carService.getClients() != null) {
            List<Client> clients = carService.getClients().stream().map(client -> clientService.create(client, carService.getId())).collect(Collectors.toList());
            carService.setClients(clients);
        }
        return carService;
    }

    @Override
    public CarService update(CarService carService, String name) {
        carServiceRepository.update(name, carService.getId());
        return carService;
    }

    @Override
    public List<CarService> selectByName(String name) {
        return carServiceRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        carServiceRepository.delete(id);
    }

    @Override
    public List<CarService> retrieveAll() {
        return carServiceRepository.findAllLeft();
    }

    @Override
    public List<CarService> selectById(Long id) {
        return carServiceRepository.findById(id);
    }
}
