package com.gokhana.emailservice.model.event

data class OrderEvent(
    val eventType: EventType,
    val order: OrderDTO
)
