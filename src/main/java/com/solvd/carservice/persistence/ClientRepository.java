package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.client.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientRepository {

    void create(Client client, Long id);

    void update(Long id, String name);

    void delete(Long id);

    default List<Client> findById(Long id) {
        List<Client> clients= new ArrayList<>();
        return clients;
    }

    default List<Client> findByName(String name) {
        List<Client> clients= new ArrayList<>();
        return clients;
    }

}
