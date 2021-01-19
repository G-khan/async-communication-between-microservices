package com.gokhana.orderservice.service

import com.gokhana.orderservice.bus.publisher.MessageProducerService
import com.gokhana.orderservice.model.OrderDTO
import com.gokhana.orderservice.model.event.EventType
import com.gokhana.orderservice.model.event.OrderEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    @Autowired
    val producer: MessageProducerService
) : OrderService {
    override fun createOrder(orderDTO: OrderDTO): OrderDTO {
        producer.sendOrderEventMessage(OrderEvent(EventType.CREATED,orderDTO))
        return orderDTO;
    }


}