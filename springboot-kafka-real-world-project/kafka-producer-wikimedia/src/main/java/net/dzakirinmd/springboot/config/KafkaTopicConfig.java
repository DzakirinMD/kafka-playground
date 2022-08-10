package net.dzakirinmd.springboot.config;

import net.dzakirinmd.springboot.kafka.producer.WikimediaChangesProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    @Bean
    public NewTopic topicWikimediaRecentchange() {
        return TopicBuilder.name(topicName)
                .build();
    }

    /**
     * commandLineRunner created in bean instead of implemented at entry class (SpringBootProducerApplication)
     * @return args
     */
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            wikimediaChangesProducer.sendMessage();
        };
    }
}
