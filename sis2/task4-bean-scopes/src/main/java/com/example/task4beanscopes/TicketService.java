package com.example.task4beanscopes;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final ObjectProvider<IdGenerator> idGenProvider;

    public TicketService(ObjectProvider<IdGenerator> idGenProvider){
        this.idGenProvider = idGenProvider;
    }

    public String newTicket() {
        return idGenProvider.getObject().id(); // new prototype instance each call
    }
}