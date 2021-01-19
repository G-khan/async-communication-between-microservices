package com.gokhana.courierservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

    private final ProducerFactory<String, Object> producerFactory;

    public KafkaProducerConfig(ProducerFactory<String, Object> producerFactory) {
        this.producerFactory = producerFactory;
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory);
    }
}
