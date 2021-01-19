package com.gokhana.orderservice.model

import com.gokhana.orderservice.model.event.EventType
import com.gokhana.orderservice.model.event.OrderEvent


fun OrderDTO.toOrderEvent(type: EventType) = OrderEvent(
    eventType = type,
    order = this
)
