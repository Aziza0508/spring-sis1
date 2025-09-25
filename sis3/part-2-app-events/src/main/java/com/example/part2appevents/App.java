package com.example.part2appevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        var app = new SpringApplication(App.class);
        app.addListeners(new AllBootEventsListener());
        app.run(args);
    }
}