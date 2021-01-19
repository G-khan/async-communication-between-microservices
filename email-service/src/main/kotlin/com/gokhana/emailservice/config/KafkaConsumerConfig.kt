package com.gokhana.emailservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.support.converter.StringJsonMessageConverter

@Configuration
@EnableKafka
class KafkaConsumerConfig(val consumerFactory: ConsumerFactory<String, String>) {

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.setMessageConverter(StringJsonMessageConverter())
        factory.consumerFactory = consumerFactory
        return factory
    }
}