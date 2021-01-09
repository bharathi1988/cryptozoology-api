package com.galvanize.zoo;

import java.util.UUID;

public class Animal {

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }

    private String name;
    private String type;
    private String id;

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
