package com.example.task2constructorinjection.impl;

import com.example.task2constructorinjection.PaymentGateway;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("stripeGateway")
@Primary
public class StripeGateway implements PaymentGateway {
    @Override
    public String pay(long cents) {
        return "stripe ok " + cents;
    }
}