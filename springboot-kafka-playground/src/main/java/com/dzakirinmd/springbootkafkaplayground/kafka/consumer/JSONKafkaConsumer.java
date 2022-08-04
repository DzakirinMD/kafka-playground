package com.dzakirinmd.springbootkafkaplayground.kafka.consumer;

import com.dzakirinmd.springbootkafkaplayground.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

//    This is a JSON deserializer. Will convert JSON Object to Java Object.
//    In below example the Topic1-json Object is converted to Java Object at the users.toString() method
    @KafkaListener(topics = "Topic1-json", groupId = "myConsumerGroup")
    public void consume(Users users) {
        LOGGER.info(String.format("JSON Message received -> %s" , users.toString()));
    }
}
