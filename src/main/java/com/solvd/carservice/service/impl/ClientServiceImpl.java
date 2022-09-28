package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.price.DiscountProgram;
import com.solvd.carservice.domain.vehicle.Car;
import com.solvd.carservice.persistence.ClientRepository;
import com.solvd.carservice.persistence.impl.ClientRepositoryImpl;
import com.solvd.carservice.service.CarService;
import com.solvd.carservice.service.ClientService;
import com.solvd.carservice.service.DiscountProgramService;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final DiscountProgramService discountProgramService;
    private final CarService carService;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
        this.discountProgramService = new DiscountProgramServiceImpl();
        this.carService = new CarServiceImpl();
    }

    @Override
    public Client create(Client client, Long carServiceId) {
        client.setId(null);
        clientRepository.create(client, carServiceId);

        if (client.getDiscountProgram() != null) {
            DiscountProgram discountProgram = discountProgramService.create(client.getDiscountProgram());
            client.setDiscountProgram(discountProgram);
        }

        if (client.getCars() != null) {
            List<Car> cars = client.getCars().stream()
                    .map(car -> carService.create(car, client.getId()))
                    .collect(Collectors.toList());
            client.setCars(cars);
        }
        return client;
    }

    @Override
    public Client update(Client client, String name) {
        clientRepository.update(client.getId(),name);
        return client;
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.delete(id);

    }

    @Override
    public List<Client> selectByCarServiceId(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> selectByLastName(String name) {
        return clientRepository.findByName(name);
    }
}
