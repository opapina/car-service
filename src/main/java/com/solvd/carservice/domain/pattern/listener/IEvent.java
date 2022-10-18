package com.solvd.carservice.domain.pattern.listener;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.service.Service;

import java.util.List;

public interface IEvent {

    void onPromotion();

    void onPerformedWork(List<Client> clients, List<Service> performedService);

}
