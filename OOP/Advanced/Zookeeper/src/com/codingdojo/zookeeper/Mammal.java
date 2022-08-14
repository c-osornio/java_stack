package com.codingdojo.zookeeper;

public abstract class Mammal {
	private int energyLevel = 100;
	private String animalType;
	
	public int displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	}
	
	public void setEnergy(int energy) {
		energyLevel += energy;
	}
	
	public String getAnimalType() {
		return animalType;
	}
	
	public void setAnimalType(String animal) {
		animalType = animal;
	}
	
//	public void displayAnimalType() {
//		System.out.println("This is a(n) " + animalType);
//	}
	
	public abstract void displayAnimalType();
}
