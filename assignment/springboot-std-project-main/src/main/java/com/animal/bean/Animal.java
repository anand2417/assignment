package com.animal.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Animal")
public class Animal {
	
	@Id
	private int id;
	private String name;
	private int speed;
	private String sound;
	private String areas;
	
	public Animal() {
		
	}
	
	
	public Animal(int id, String name, int speed, String sound, String areas) {
		super();
		this.id = id;
		this.name = name;
		this.speed = speed;
		this.sound = sound;
		this.areas = areas;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getAreas() {
		return areas;
	}
	public void setAreas(String areas) {
		this.areas = areas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
