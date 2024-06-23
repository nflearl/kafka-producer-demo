package edu.wgu.domain;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        send("private-earl-test", "Java Producer: " + System.currentTimeMillis());
    }

    @SuppressWarnings({"SameParameterValue"})
    private void send(String topic, String message) {
        kafkaTemplate.send(topic, new String(UUID.randomUUID().toString()));
    }

//    private record String(String wguid) {}
}
