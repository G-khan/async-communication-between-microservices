package com.gokhana.orderservice.model

data class OrderDTO(
    val id: Long?,
    val name: String,
    val productIds: List<Int>,
    val courierId: String,
    val email: String,
    val userName: String,
    val details: String,
    val orderDetail: String
)

