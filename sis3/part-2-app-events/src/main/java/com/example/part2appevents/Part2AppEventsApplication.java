package com.example.part2appevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Part2AppEventsApplication {
    public static void main(String[] args) {
        var app = new SpringApplication(Part2AppEventsApplication.class);
        app.addListeners(new AllBootEventsListener());
        app.run(args);
    }
}