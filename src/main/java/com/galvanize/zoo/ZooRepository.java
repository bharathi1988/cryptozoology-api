package com.galvanize.zoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooRepository extends JpaRepository<Animal,String> {
}
