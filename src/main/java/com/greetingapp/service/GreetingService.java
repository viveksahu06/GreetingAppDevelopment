package com.greetingapp.service;

import com.greetingapp.entity.GreetingEntity;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private String message;
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    //Method to save all the greetings
    public GreetingEntity saveGreetingRepository(String firstname, String lastName){
        //Generate message
        String message =getGreetingService(firstname , lastName);
        //Make and store the message
        GreetingEntity entity = new GreetingEntity(firstname , lastName , message);
        return greetingRepository.save(entity);
    }
    //method to get all the greetings
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<GreetingEntity> getGreetingById(Long id){
        return greetingRepository.findById(id);
    }

    //To resetMessage
    public GreetingEntity editAGreetingMessage(Long id,String message){
        Optional<GreetingEntity> entityOptional = getGreetingById(id);
        if(entityOptional.isPresent()){
            GreetingEntity entity = entityOptional.get();
            entity.setMessage(message);
            return greetingRepository.save(entity);
        }
        else{
            throw new RuntimeException("Greeting with ID " + id + " not found");
        }
    }
    public GreetingEntity deleteAGreetingMessageById(Long id){
        Optional<GreetingEntity> entityOptional = getGreetingById(id);
        if(entityOptional.isPresent()){
            GreetingEntity entity = entityOptional.get();
            entity.setMessage(null);
            return greetingRepository.save(entity);
        }
        else{
            throw new RuntimeException("Greeting with ID " + id + " not found");
        }
    }

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
