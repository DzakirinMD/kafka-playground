package com.dzakirinmd.springbootkafkaplayground.controller;

import com.dzakirinmd.springbootkafkaplayground.kafka.producer.StringKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private StringKafkaProducer stringKafkaProducer;

//    public MessageController(StringKafkaProducer stringKafkaProducer) {
//        this.stringKafkaProducer = stringKafkaProducer;
//    }

    // http://localhost:8080/api/v1/kafka/publish?message=Hello Kafka
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {

        stringKafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message : " + message + " , has been publish to the topic!");
    }
}