package com.codingdojo.zookeeper;

public class TestZoo {

	public static void main(String[] args) {
		Gorilla Kong = new Gorilla();
		Kong.setEnergy(100);
		Kong.throwThings();
		Kong.throwThings();
		Kong.throwThings();
		Kong.eatBananas();
		Kong.eatBananas();
		Kong.climb();
		Kong.displayEnergy();
		Kong.displayAnimalType();
		
		
		Bat CountChocula = new Bat();
		CountChocula.attackTown();
		CountChocula.attackTown();
		CountChocula.attackTown();
		CountChocula.eatHumans();
		CountChocula.eatHumans();
		CountChocula.fly();
		CountChocula.fly();
		CountChocula.displayEnergy();
		CountChocula.displayAnimalType();
	}

}