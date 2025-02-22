package com.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private String message;
    public String getGreetingService(String firstName, String lastName){
        if(firstName!= null && lastName != null){
            return "Hello " + firstName + " " + lastName;
        }
        if(firstName!=null){
            return "Hello "+ firstName;
        }
        if(lastName!=null){
            return "Hello "+ lastName;
        }
        return "Hello World";
    }
}
