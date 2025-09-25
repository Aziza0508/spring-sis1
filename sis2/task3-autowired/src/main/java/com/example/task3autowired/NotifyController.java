package com.example.task3autowired.web;

import com.example.task3autowired.service.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyController {

    @Autowired
    private Notifier notifier;

    @GetMapping("/notify")
    public Object all(@RequestParam String m) {
        return notifier.broadcast(m);
    }

    @GetMapping("/notifyOne")
    public String one(@RequestParam String m) {
        return notifier.email(m);
    }
}