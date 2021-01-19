package com.gokhana.orderservice.bus.publisher

import com.gokhana.orderservice.model.event.OrderEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFutureCallback

@Service
class KafkaMessageProducerManager(val kafkaTemplate: KafkaTemplate<String, Any>) : MessageProducerService {

    private val LOG = LoggerFactory.getLogger(KafkaMessageProducerManager::class.java)


    @Value(value = "\${kafka.topic.orderEvent}")
    private val orderEventTopic: String? = null


    @Async
    override fun sendOrderEventMessage(orderEvent: OrderEvent?) {
        LOG.debug("orderEvent object is sending.. -> $orderEvent")
        val future = kafkaTemplate.send(
            orderEventTopic!!, orderEvent
        )
        future.addCallback(object : ListenableFutureCallback<SendResult<String?, Any?>?> {
            override fun onSuccess(result: SendResult<String?, Any?>?) {
                LOG.debug(
                    "Sent message='{}' with offset={}",
                    orderEventTopic,
                    result!!.recordMetadata.offset()
                )
            }

            override fun onFailure(ex: Throwable) {
                LOG.error("Unable to send message='{}'", orderEventTopic, ex)
            }
        })
    }

}