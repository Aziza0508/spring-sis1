package com.example.task2constructorinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGateway gateway;

    public PaymentService(@Qualifier("stripeGateway") PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String charge(long cents) {
        return gateway.pay(cents);
    }
}