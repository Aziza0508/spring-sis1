package com.example.part1events.events;

public record OrderCreated(Long orderId, String item, int qty) {}