package com.example.task3autowired.channel;

import org.springframework.stereotype.Component;

@Component("emailChannel")
public class EmailChannel implements NotificationChannel {
    @Override public String send(String m) { return "email:" + m; }
}