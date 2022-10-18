package com.solvd.carservice.domain.pattern.listener;

import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For all subscribe client can send promotion message
 * Only for client which service works are completed can send message about performed work
 */

public class EventHolder {

    private static final Map<EventType, List<IEvent>> HOLDER = new HashMap<>();

    public static void subscription( IEvent event, EventType type) {
        if (HOLDER.get(type) == null) {
            HOLDER.put(type, new ArrayList<>());
        }
        HOLDER.get(type).add(event);
    }

    public static void eventMessage(EventType type, List<Client> clients, List<Service> performedServices) {
        List<IEvent> events = HOLDER.get(type);
        if (events != null) {
            if (type == EventType.PROMOTION) {
                events.forEach(IEvent::onPromotion);
            }
            else if (type == EventType.PERFORMEDWORK) {
                events.get(0).onPerformedWork(clients, performedServices);
            }
        }
    }
}
