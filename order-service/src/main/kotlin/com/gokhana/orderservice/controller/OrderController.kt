package com.gokhana.orderservice.controller

import com.gokhana.orderservice.model.OrderDTO
import com.gokhana.orderservice.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun orderApi(@RequestBody orderDTO: OrderDTO): ResponseEntity<OrderDTO> {
        val createdOrder = orderService.createOrder(orderDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder)
    }

}