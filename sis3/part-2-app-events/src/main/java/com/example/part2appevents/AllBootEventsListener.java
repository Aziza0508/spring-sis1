package com.example.part2appevents;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

class AllBootEventsListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("BOOT EVENT: " + event.getClass().getSimpleName());
    }
}