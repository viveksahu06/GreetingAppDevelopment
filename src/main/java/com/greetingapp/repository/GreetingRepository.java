package com.greetingapp.repository;

import com.greetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//To add all the greetings
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
