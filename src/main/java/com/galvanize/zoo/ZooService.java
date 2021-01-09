package com.galvanize.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    @Autowired
    ZooRepository repository;

    public Animal addAnimal(Animal animal) {
        return repository.saveAndFlush(animal);
    }

    public List<Animal> getAnimals() {
        return repository.findAll();
    }

    public Animal feedAnimal(String id) {
        Animal animal = repository.getOne(id);
        animal.setMood("Happy");
        return repository.saveAndFlush(animal);
    }
}
