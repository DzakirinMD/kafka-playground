package net.dzakirinmd.springboot.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    /**
     * The consumeMessage() method is to consume messages from topics
     * @param eventMessage
     *        stream of message from the KafkaTopic
     */
    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMessage(String eventMessage) {

        LOGGER.info(String.format("String Event message received -> %s" , eventMessage));
    }
}
