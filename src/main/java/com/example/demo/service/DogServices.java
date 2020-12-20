package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServices {

    // klasa servis odpowiedzialna za przechowywanie logiki biznesowej związanej z modelem dog

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public Dog findById(Integer dogId) {
        return dogRepository.findById(dogId).isPresent() ? dogRepository.findById(dogId).get() : null;
    }
}
