package com.gokhana.orderservice

import com.gokhana.orderservice.model.OrderDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class OrderServiceApplicationTests(@Autowired val restTemplate: TestRestTemplate) {


    @Test
    fun `When create order with correct order's data  then create order successfully`() {
        val orderDTO = OrderDTO(1, "Gökhan", "123","K34","gokhana@mail.com","g-khan","details","order details")
        val entity = restTemplate.postForEntity<String>("/orders", orderDTO)
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.CREATED)
    }
}
