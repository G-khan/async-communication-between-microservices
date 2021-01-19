package com.gokhana.orderservice.model.event

import com.gokhana.orderservice.model.OrderDTO

data class OrderEvent (
    val eventType: EventType,
    val order: OrderDTO
)
