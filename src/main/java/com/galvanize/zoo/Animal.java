package com.galvanize.zoo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Animal {
    @Id
    private String id;
    private String name;
    private String type;


    public Animal(){

    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
