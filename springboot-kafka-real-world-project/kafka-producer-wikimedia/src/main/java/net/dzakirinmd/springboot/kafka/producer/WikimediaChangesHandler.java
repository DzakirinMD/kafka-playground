package net.dzakirinmd.springboot.kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    /**
     * Only using onMessage() method.
     * it will trigger whenever there is new event in wikimedia. The onMessage() method will send the message to the topic
     *
     * @param s
     * @param messageEvent
     *
     */
    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {

        LOGGER.info(String.format("event data -> %s" , messageEvent.getData()));

        kafkaTemplate.send(topicName, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
