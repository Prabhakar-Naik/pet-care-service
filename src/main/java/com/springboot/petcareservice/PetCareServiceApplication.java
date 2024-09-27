package com.springboot.petcareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetCareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareServiceApplication.class, args);
        System.out.println("Pet Care Service Application Running...@");
    }

}
