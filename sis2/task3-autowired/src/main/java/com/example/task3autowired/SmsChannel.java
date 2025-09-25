package com.example.task3autowired.channel;

import org.springframework.stereotype.Component;

@Component("smsChannel")
public class SmsChannel implements NotificationChannel {
    @Override public String send(String m) { return "sms:" + m; }
}