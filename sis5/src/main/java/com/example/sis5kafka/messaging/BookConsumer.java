package com.example.sis5kafka.messaging;

import com.example.sis5kafka.model.BookCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BookConsumer {
    private static final Logger log = LoggerFactory.getLogger(BookConsumer.class);

    @KafkaListener(topics = "${app.kafka.topic:books.created}", groupId = "sis5-consumers")
    public void onEvent(@Payload BookCreatedEvent event) {
        log.info("Consumed BookCreatedEvent: id={}, title='{}', author='{}'",
                event.getId(), event.getTitle(), event.getAuthor());
        // here you could call a service / persist to DB etc.
    }
}
