package com.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private String message;
    public String getGreetingService(){
        return "Hello World";
    }
}
