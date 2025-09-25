package com.example.part1events;

import com.example.part1events.events.OrderCreated;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.context.event.EventListener;

@Configuration
@EnableAsync
class AsyncCfg {}

@Component
class AuditListener {
    @EventListener
    public void onCreated(OrderCreated e){
        System.out.println("[SYNC] audit " + e);
    }
}

@Component
class EmailListener {
    @Async
    @EventListener
    public void sendEmail(OrderCreated e) throws InterruptedException {
        Thread.sleep(300);
        System.out.println("[ASYNC] email " + e);
    }
}

@Component
class TxListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(OrderCreated e){
        System.out.println("[TX AFTER_COMMIT] " + e);
    }
}