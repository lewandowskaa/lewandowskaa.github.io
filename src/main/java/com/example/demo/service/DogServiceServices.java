package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.model.DogService;
import com.example.demo.repository.DogServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DogServiceServices {

    // klssa servis odpowiedzialna za przechowywanie logiki biznesowej związanej z modelem dogService

    @Autowired
    private DogServiceRepository dogServiceRepository;

    @Autowired
    private DogServices dogServices;

    public List<DogService> findAll(Integer dogId) {
        Dog dog = dogServices.findById(dogId);
        if (dog != null) {
            return dogServiceRepository.findAllByDog(dog);
        } else {
            return Collections.emptyList();
        }
    }

    public DogService findById(Integer dogServiceId) {
        return dogServiceRepository.findById(dogServiceId).isPresent() ? dogServiceRepository.findById(dogServiceId).get() : null;
    }
}
