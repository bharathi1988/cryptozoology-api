package com.galvanize.zoo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Animal,String> {
}
