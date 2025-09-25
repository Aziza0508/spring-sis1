package com.example.task4beanscopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IdGenerator {
    private final String id = java.util.UUID.randomUUID().toString();
    public String id(){ return id; }
}