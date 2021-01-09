package com.galvanize.zoo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Animal {
    @Id
    private String id;
    private String name;
    private String type;
    private String mood;

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }

    public Animal(){

    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = UUID.randomUUID().toString();
        this.mood = "Unhappy";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && Objects.equals(type, animal.type) && Objects.equals(mood, animal.mood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, mood);
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}
