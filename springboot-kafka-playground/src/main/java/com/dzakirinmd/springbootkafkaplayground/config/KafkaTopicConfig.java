package com.dzakirinmd.springbootkafkaplayground.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic playgroundTopic() {
//        .partitions can be removed if want to use default number of partition by spring
        return TopicBuilder.name("Topic1")
                .partitions(10)
                .build();
    }
}
