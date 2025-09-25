package com.example.task4beanscopes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private final TicketService svc;

    public TicketController(TicketService svc){
        this.svc = svc;
    }

    @GetMapping("/ticket")
    public String ticket() {
        return svc.newTicket();
    }
}