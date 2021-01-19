package com.gokhana.orderservice.service

import com.gokhana.orderservice.model.OrderDTO

interface OrderService {

    fun createOrder(orderDTO: OrderDTO): OrderDTO;
}