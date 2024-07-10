package edu.wgu.domain;

import edu.wgu.Book;
import edu.wgu.Dog;
import edu.wgu.ZZEarl;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Producer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        send("private-earl-test", "Java Producer: " + System.currentTimeMillis());
    }

    @SuppressWarnings({"SameParameterValue"})
    private void send(String topic, String message) {
        kafkaTemplate.send(topic, new ZZEarl(UUID.randomUUID().toString()));
        kafkaTemplate.send(topic, new Book("Jungle Book", "isbn", 99));
        kafkaTemplate.send(topic, new Dog("Spot", 14));
    }

//    private record String(String wguid) {}
}
