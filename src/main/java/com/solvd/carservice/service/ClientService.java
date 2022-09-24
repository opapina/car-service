package com.solvd.carservice.service;

import com.solvd.carservice.domain.client.Client;

public interface ClientService {

    Client create(Client client, Long id);

}
