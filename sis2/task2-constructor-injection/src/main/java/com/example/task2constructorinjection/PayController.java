package com.example.task2constructorinjection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    private final PaymentService payments;

    public PayController(PaymentService payments) {
        this.payments = payments;
    }

    @GetMapping("/pay")
    public String pay(@RequestParam long cents) {
        return payments.charge(cents);
    }
}