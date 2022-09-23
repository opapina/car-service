package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.persistence.ClientRepository;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {


    @Override
    public void create(Client client) {

    }

    @Override
    public List<Client> findAll() {
        return ClientRepository.super.findAll();
    }
}
