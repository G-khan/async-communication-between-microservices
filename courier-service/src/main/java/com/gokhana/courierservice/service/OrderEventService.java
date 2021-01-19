package com.gokhana.courierservice.service;

import com.gokhana.courierservice.model.event.EventType;
import com.gokhana.courierservice.model.event.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderEventService {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderEventService.class);

    List<String> couriers = List.of("Ahmet", "Mehmet", "Gökhan", "John", "Leonardo", "Jane", "Elon");
    Random rand = new Random();

    public void assignCourier(OrderEvent orderEvent) {
        if (orderEvent.getEventType() == EventType.CREATED) {
            LOGGER.info("Courier: {} is assigned to Requested Order: {}", couriers.get(rand.nextInt(couriers.size())), orderEvent.getOrder());
        }
    }
}
