package com.galvanize.zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {

    @Autowired
    ZooService zooService;

    @PostMapping( "/zoo/animals")
    @ResponseStatus(HttpStatus.CREATED)
    Animal addAnimal(@RequestBody Animal animal){
        return zooService.addAnimal(animal);

    }

}
