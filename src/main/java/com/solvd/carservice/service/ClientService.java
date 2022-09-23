package com.solvd.carservice.service;

import com.solvd.carservice.domain.client.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client, Long id);

    List<Client> retrieveAll();
}
