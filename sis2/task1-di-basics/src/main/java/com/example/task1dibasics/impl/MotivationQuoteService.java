package com.example.task1dibasics.impl;

import com.example.task1dibasics.QuoteService;
import org.springframework.stereotype.Service;

@Service
public class MotivationQuoteService implements QuoteService {
    @Override
    public String quote() {
        return "Ship small, learn fast.";
    }
}