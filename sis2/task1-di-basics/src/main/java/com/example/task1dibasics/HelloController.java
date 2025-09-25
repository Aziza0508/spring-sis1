package com.example.task1dibasics;

import com.example.task1dibasics.QuoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final QuoteService quotes;

    public HelloController(QuoteService quotes) {
        this.quotes = quotes;
    }

    @Value("${app.welcome:Hello!}")
    private String welcome;

    @Value("#{'${app.tags}'.split(',')}")
    private List<String> tags;

    @GetMapping("/hello")
    public String hello() {
        return welcome + " | " + quotes.quote() + " | tags=" + tags;
    }
}