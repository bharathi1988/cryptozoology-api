package com.galvanize.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    @Autowired
    ZooRepository repository;

    public Animal addAnimal(Animal animal) {

        repository.save(animal);

        return new Animal(animal.getName(),animal.getType());
        //return animal;
    }
}
