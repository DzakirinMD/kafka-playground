package com.dzakirinmd.springbootkafkaplayground.kafka.producer;

import com.dzakirinmd.springbootkafkaplayground.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * This JSON is for String producer
 *
 * using @Service to make this class a java bean
 */

@Service
public class JSONKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaProducer.class);

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Autowired
    private KafkaTemplate<String, Users> kafkaTemplate;

    public void sendMessage(Users data) {

        LOGGER.info(String.format("JSON Message sent -> %s" , data.toString()));

        Message<Users> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
