package com.gokhana.emailservice.service

import com.gokhana.emailservice.model.event.EventType
import com.gokhana.emailservice.model.event.OrderEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OrderEventService {
    private val LOGGER: Logger = LoggerFactory.getLogger(OrderEventService::class.java)

    fun sendEmail(orderEvent: OrderEvent) {
        if (orderEvent.eventType === EventType.CREATED) {
            LOGGER.info(
                "Email is sending for ${orderEvent.order.userName} to ${orderEvent.order.email}"
            )
        }
    }
}