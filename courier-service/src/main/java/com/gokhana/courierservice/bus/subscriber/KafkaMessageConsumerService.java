package com.gokhana.courierservice.bus.subscriber;

import com.gokhana.courierservice.model.event.OrderEvent;
import com.gokhana.courierservice.service.OrderEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumerService {

    final OrderEventService orderEventService;
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumerService.class);

    public KafkaMessageConsumerService(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }

    @KafkaListener(topics = "${kafka.topic.orderEvent}")
    public void consumeUserOrderEvent(OrderEvent orderEvent) {
        LOGGER.info("Message Received. otherTemplate: {}", orderEvent);
        orderEventService.assignCourier(orderEvent);
    }

}
