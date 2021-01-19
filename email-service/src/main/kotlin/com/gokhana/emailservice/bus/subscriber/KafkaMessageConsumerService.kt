package com.gokhana.emailservice.bus.subscriber

import com.gokhana.emailservice.model.event.OrderEvent
import com.gokhana.emailservice.service.OrderEventService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaMessageConsumerService(@Autowired val orderEventService: OrderEventService) {
    private val LOGGER = LoggerFactory.getLogger(KafkaMessageConsumerService::class.java)

    @KafkaListener(topics = ["\${kafka.topic.orderEvent}"])
    fun consumeUserOrderEvent(orderEvent: OrderEvent?) {
        LOGGER.info("Message Received. otherTemplate: {$orderEvent}")
        if (orderEvent != null) {
            orderEventService.sendEmail(orderEvent)
        }
    }
}