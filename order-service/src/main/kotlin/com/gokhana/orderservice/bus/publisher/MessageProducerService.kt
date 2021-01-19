package com.gokhana.orderservice.bus.publisher

import com.gokhana.orderservice.model.event.OrderEvent

interface MessageProducerService {
    fun sendOrderEventMessage(orderEvent: OrderEvent?)
}