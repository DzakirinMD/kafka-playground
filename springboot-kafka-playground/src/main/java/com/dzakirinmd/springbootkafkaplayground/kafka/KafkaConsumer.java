package com.dzakirinmd.springbootkafkaplayground.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

//    Subscribe to Topic1 . There can be a lot of subscribers
    @KafkaListener(topics = "Topic1", groupId = "myConsumerGroup")
    public void consume(String message) {

        LOGGER.info(String.format("Message received -> %s" , message));
    }
}
