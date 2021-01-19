package com.gokhana.orderservice.model

data class OrderDTO(
    val id: Long?,
    val name: String,
    val productId: String,
    val courierId: String,
    val email: String,
    val userName: String,
    val details: String,
    val orderDetail: String
)

