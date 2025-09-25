package com.example.part1events;

import com.example.part1events.domain.Order;
import com.example.part1events.domain.OrderRepository;
import com.example.part1events.events.OrderCreated;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository repo;
    private final ApplicationEventPublisher events;

    public OrderService(OrderRepository r, ApplicationEventPublisher e) {
        this.repo = r; this.events = e;
    }

    @Transactional
    public Order create(String item, int qty) {
        var o = repo.save(new Order(item, qty)); // uses our constructor
        events.publishEvent(new OrderCreated(o.getId(), item, qty));
        return o;
    }
}