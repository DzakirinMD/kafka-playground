package com.dzakirinmd.springbootkafkaplayground.controller;

import com.dzakirinmd.springbootkafkaplayground.kafka.producer.JSONKafkaProducer;
import com.dzakirinmd.springbootkafkaplayground.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JSONKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Users users){

        jsonKafkaProducer.sendMessage(users);

        return ResponseEntity.ok("Json Message : " + users + " , has been publish to the topic!");
    }
}
