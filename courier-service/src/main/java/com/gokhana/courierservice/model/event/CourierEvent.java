package com.gokhana.courierservice.model.event;

import com.gokhana.courierservice.model.Courier;

public class CourierEvent {

    private EventType eventType;
    private Courier courier;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @Override
    public String toString() {
        return "CourierEvent{" +
                "eventType=" + eventType +
                ", courier=" + courier +
                '}';
    }
}
