package com.animal.service;

import java.util.ArrayList;
import java.util.List;

import com.animal.bean.Animal;
import com.animal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	
	@Autowired
	public AnimalRepository AnimalRepo;
	
	public List<Animal> getAllAnimals(){
		
		List<Animal> animals = new ArrayList<>();
		AnimalRepo.findAll().forEach(animals::add);
		return animals;
	}

	public Animal addAnimal(Animal animal) {
		AnimalRepo.save(animal);
		return animal;
		
	}

	public String updateAnimal(Animal animal) {
		AnimalRepo.save(animal);
		return "updated employee";
	}

	public void deleteAnimal(int id) {
		AnimalRepo.deleteById(id);
		
	}


}
