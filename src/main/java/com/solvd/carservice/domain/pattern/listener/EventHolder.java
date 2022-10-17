package com.solvd.carservice.domain.pattern.listener;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventHolder {

    private static final Map<EventType, List<IEvent>> HOLDER = new HashMap<>();

    public static void subscription(Client client, IEvent event, EventType type) {
        if (HOLDER.get(type) == null) {
            HOLDER.put(type, new ArrayList<>());
        }
        if (client.getPhoneNumber() != null) {
            HOLDER.get(type).add(event);
        }
    }

        public static void eventMessage (EventType type, List<Client> clients, List<Service> performedServices) {
            List<IEvent> events = HOLDER.get(type);
            if (events != null) {
                if (type == EventType.PROMOTION) {
                    events.forEach(event -> event.onPromotion());
//                } else {
//                    events.forEach(event -> event.onPerformedWork(clients, performedServices));
//                    if (performedServices != null) {
//                        for (int i = 0; i < performedServices.size(); i++) {
//                        int numberCar = client.getCars().size();
//                        for (int j = 0; j < numberCar; j++) {
//                            int numberService = client.getCars().get(i).getServices().size();
//                            for (int n = 0; n < numberService; n++) {
//                                if (client.getCars().get(j).getServices().get(n).getId().equals(performedServices.get(i).getId())) {
//                                    return;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            events.forEach(event -> event.onEvent(client, type, performedServices));
//
                }
            }
        }
}
