package com.dzakirinmd.springbootkafkaplayground.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * This producer is for String producer
 *
 * using @Service to make this class a java bean
 */
@Service
public class StringKafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;


    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void sendMessage(String message) {

        LOGGER.info(String.format("Message sent %s" , message));
//        LOGGER.info("The message being sent is : " + message );
        kafkaTemplate.send(topicName, message);
    }
}
