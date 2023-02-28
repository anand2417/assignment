package com.animal.controller;

import java.util.List;

import com.animal.bean.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
	
	@Autowired
	private com.animal.service.AnimalService AnimalService;
	
	
	@RequestMapping("/animals")
	public List<Animal> getAllAnimals(){
		
		return AnimalService.getAllAnimals();
		
	}
	
	@RequestMapping(method= RequestMethod.POST , value="/animals")
	public void addAnimal(@RequestBody Animal animal) {
		
		AnimalService.addAnimal(animal);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updateAnimal/{id}")
	public void updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
		AnimalService.updateAnimal(animal);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void deleteAnimal(@PathVariable int id){
		AnimalService.deleteAnimal(id);
	}

}
