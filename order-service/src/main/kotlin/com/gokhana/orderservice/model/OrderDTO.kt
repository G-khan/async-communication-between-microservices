package com.gokhana.orderservice.model

import kotlin.random.Random

data class OrderDTO(
    val id: Long? = Random.nextLong(0, 1000),
    val name: String,
    val productIds: List<Int>,
    val email: String,
    val userName: String,
    val details: String?,
    val orderDetail: String
)