package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.client.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientRepository {

    void create(Client client);

    default List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        return clients;
    }

}
