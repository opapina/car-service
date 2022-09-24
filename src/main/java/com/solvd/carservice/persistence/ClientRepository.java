package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.client.Client;

public interface ClientRepository {

    void create(Client client, Long id);

}
