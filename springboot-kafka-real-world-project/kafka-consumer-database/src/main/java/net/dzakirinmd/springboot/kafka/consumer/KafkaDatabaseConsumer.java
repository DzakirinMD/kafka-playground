package net.dzakirinmd.springboot.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic-json.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMessage(String eventMessage) {

        LOGGER.info(String.format("String Event message received -> %s" , eventMessage));
    }
}
