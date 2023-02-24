package com.animal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.animal.bean.Animal;
import com.animal.repository.AnimalRepository;
import com.animal.service.AnimalService;


@RunWith(SpringRunner.class)
@SpringBootTest
class Animal2ApplicationTests {


	
	@Autowired
	private AnimalService animalService;
	
	@MockBean
	private AnimalRepository AnimalRepo;
	
	@Test
	public void getAnimalTest() {
		when(AnimalRepo.findAll()).thenReturn(Stream.of(new Animal(10,"lion",24,"roar","africa")).collect(Collectors.toList()));
		assertEquals(1, animalService.getAllAnimals().size());
	}
	
	
	@Test
	public void addAnimalTest() {
		Animal animal = new Animal(10,"lion",24,"roar","africa");
		when(AnimalRepo.save(animal)).thenReturn(animal);
		assertEquals(animal, animalService.addAnimal(animal));
		
	}

	@Test
	public void deleteAnimalTest() {
		int n=223;
		animalService.deleteAnimal(n);
		verify(AnimalRepo,times(1)).deleteById(n);
		
	}
	@Test
	public void updateAnimalTest() {
		Animal animal = new Animal(10,"lion",24,"roar","africa");
		when(AnimalRepo.save(animal)).thenReturn(animal);
		assertEquals("updated animal", animalService.updateAnimal(animal));
	}
	
}

