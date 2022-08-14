package com.codingdojo.zookeeper;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		this.setAnimalType("Gorilla");
	}
	
	public void throwThings() {
		System.out.println("The gorilla is throwing things at people!");
		this.setEnergy(-5);
	}
	
	public void eatBananas() {
		System.out.println("The gorilla eats a delicious banana!");
		this.setEnergy(10);
	}
	
	public void climb() {
		System.out.println("The gorilla is climbing all over the place!");
		this.setEnergy(-10);
	}
	
	public void displayAnimalType() {
		System.out.println("This is a Gorilla!");
	}
}