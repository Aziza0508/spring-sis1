package com.example.sis5kafka.messaging;

import com.example.sis5kafka.model.BookCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookProducer {

    private final KafkaTemplate<String, BookCreatedEvent> kafkaTemplate;
    private final String topic;

    public BookProducer(KafkaTemplate<String, BookCreatedEvent> kafkaTemplate,
                        @Value("${app.kafka.topic:books.created}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(BookCreatedEvent event) {
        kafkaTemplate.send(topic, event.getId(), event);
    }
}
