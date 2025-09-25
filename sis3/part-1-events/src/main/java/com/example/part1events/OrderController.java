package com.example.part1events;

import com.example.part1events.domain.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
class OrderController {
    private final OrderService svc;
    public OrderController(OrderService s){ this.svc = s; }

    @PostMapping
    public Order create(@RequestParam String item, @RequestParam int qty){
        return svc.create(item, qty);
    }
}