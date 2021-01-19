package com.gokhana.courierservice.model.event;


public class OrderEvent {
    private EventType eventType;
    private OrderDTO order;

    public OrderEvent() {
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO orderDTO) {
        this.order = orderDTO;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "eventType=" + eventType +
                ", orderDTO=" + order +
                '}';
    }
}
