package com.dzakirinmd.springbootkafkaplayground.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaConsumer.class);

//    Subscribe to Topic1 . There can be a lot of subscribers. This is a string deserializer
    @KafkaListener(topics = "Topic1", groupId = "myConsumerGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s" , message));
    }
}
