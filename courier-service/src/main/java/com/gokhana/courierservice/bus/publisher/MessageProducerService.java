package com.gokhana.courierservice.bus.publisher;


import com.gokhana.courierservice.model.event.CourierEvent;

public interface MessageProducerService {

    void sendCourierEvent(CourierEvent courierEvent);
}
