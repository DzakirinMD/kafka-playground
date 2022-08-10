package com.dzakirinmd.springbootkafkaplayground.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void sendMessage(String message) {

        LOGGER.info(String.format("String Message sent %s" , message));
//        LOGGER.info("The message being sent is : " + message );
        kafkaTemplate.send(topicName, message);
    }
}
