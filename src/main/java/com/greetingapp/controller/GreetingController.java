package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //Extending controller to say hello world
    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        String message = greetingService.getGreetingService(firstName,lastName);
        return new Greeting(message);
    }
    @GetMapping
    public Greeting getGreeting(){
        return new Greeting("Hello : this is get mapping");
    }
    @PutMapping
    public Greeting putGreeting(){
        return new Greeting("Hello : this is put mapping");
    }

    @DeleteMapping
    public Greeting deleteGreeting(){
        return new Greeting("Hello : this is delete mapping");
    }

    @PostMapping
    public Greeting postGreeting(){
        return new Greeting("Hello : this is post mapping");
    }

}
