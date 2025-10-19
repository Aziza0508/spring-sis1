package com.example.sis5kafka.web;

import com.example.sis5kafka.messaging.BookProducer;
import com.example.sis5kafka.model.BookCreatedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookProducer producer;

    public BookController(BookProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody BookCreatedEvent dto) {
        if (dto.getId() == null || dto.getId().isBlank()) {
            dto.setId(UUID.randomUUID().toString());
        }
        producer.send(dto);
        return ResponseEntity.accepted().body(Map.of(
                "status", "queued",
                "id", dto.getId()
        ));
    }
}
