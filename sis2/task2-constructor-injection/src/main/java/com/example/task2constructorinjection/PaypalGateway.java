package com.example.task2constructorinjection.impl;

import com.example.task2constructorinjection.PaymentGateway;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("paypalGateway")
public class PaypalGateway implements PaymentGateway {
    @Override
    public String pay(long cents) {
        return "paypal ok " + cents;
    }

    @Service("stripeGateway")
    @Primary
    public static class StripeGateway implements PaymentGateway {
        @Override
        public String pay(long cents) {
            return "stripe ok " + cents;
        }
    }
}