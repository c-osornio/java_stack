package com.codingdojo.zookeeper;

public class Bat extends Mammal{

	public Bat() {
		this.setAnimalType("Bat");
		this.setEnergy(300);
	}
	
	public void fly() {
		System.out.println("Squeak squeak squeak");
        this.setEnergy(-50);
	}
	
	public void eatHumans() {
		System.out.println("Sucking blood of humans");
        this.setEnergy(25);
	}
	
	public void attackTown() {
		System.out.println("Townfolk screaming as their town burns");
        this.setEnergy(-100);
	}
	
	public void displayAnimalType() {
		System.out.println("This is a Bat!");
	}
}
