package com.example.part1events.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;

    private String item;
    private int qty;

    protected Order() {}

    public Order(String item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public Long getId() { return id; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
}
