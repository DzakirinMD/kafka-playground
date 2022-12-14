package com.dzakirinmd.springbootkafkaplayground.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic playgroundStringTopic() {
//        .partitions can be removed if want to use default number of partition by spring
        return TopicBuilder.name(topicName)
                .partitions(10)
                .build();
    }

    @Bean
    public NewTopic playgroundJSONTopic() {
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
