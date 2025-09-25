package com.example.task2constructorinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGateway gateway;

    // Prefer constructor injection; @Autowired optional on single constructor
    public PaymentService(@Qualifier("stripeGateway") PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String charge(long cents) {
        return gateway.pay(cents);
    }
}