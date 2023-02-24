package com.animal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.animal.bean.Animal;

public interface AnimalRepository extends MongoRepository<Animal,Integer> {

}
