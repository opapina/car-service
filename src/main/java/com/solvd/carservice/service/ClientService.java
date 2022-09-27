package com.solvd.carservice.service;

import com.solvd.carservice.domain.client.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client, Long id);

    Client update(Client client, String name);

    void deleteById(Long id);

    List<Client> selectByCarServiceId(Long id);

    List<Client> selectByLastName(String name);

}
