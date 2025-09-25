package com.example.task3autowired.service;

import com.example.task3autowired.channel.NotificationChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Notifier {
    private final List<NotificationChannel> channels;
    private final NotificationChannel primary;

    public Notifier(List<NotificationChannel> channels,
                    @Qualifier("emailChannel") NotificationChannel primary) {
        this.channels = channels;
        this.primary = primary;
    }

    public List<String> broadcast(String msg) {
        return channels.stream().map(c -> c.send(msg)).toList();
    }

    public String email(String msg) {
        return primary.send(msg);
    }
}