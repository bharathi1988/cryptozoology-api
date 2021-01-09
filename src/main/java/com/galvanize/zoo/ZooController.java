package com.galvanize.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZooController {

    @Autowired
    ZooService zooService;

    @PostMapping( "/zoo/animals")
    @ResponseStatus(HttpStatus.CREATED)
    Animal addAnimal(@RequestBody Animal animal){
        return zooService.addAnimal(animal);

    }

    @GetMapping("/zoo/animals")
    List<Animal> getAnimals(){
        return zooService.getAnimals();
    }

    @PutMapping("/zoo/animals")
    Animal feedAnimals(@RequestBody String id){
        return zooService.feedAnimal(id);
    }

    @PostMapping("/zoo/allocateanimals")
    Animal allocateAnimals(@RequestBody String id){
        return zooService.allocateAnimals(id);
    }

}
