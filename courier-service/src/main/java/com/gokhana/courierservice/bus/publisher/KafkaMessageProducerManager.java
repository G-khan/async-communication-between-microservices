package com.gokhana.courierservice.bus.publisher;

import com.gokhana.courierservice.model.event.CourierEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaMessageProducerManager implements MessageProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageProducerManager.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value(value = "${kafka.topic.courierEvent}")
    private String courierEventTopic;

    public KafkaMessageProducerManager(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Async
    public void sendCourierEvent(CourierEvent courierEvent) {
        LOG.debug("courierEvent object is sending.. -> {}", courierEvent);

        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(courierEventTopic, courierEvent);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LOG.debug("Sent message='{}' with offset={}", courierEventTopic, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOG.error("Unable to send message='{}'", courierEventTopic, ex);
            }

        });
    }

}
