package com.codingdojo.abstractart;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String material, String title, String author, String description) {
		super(title, author, description);
		this.setMaterial(material);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		System.out.printf("\nMaterial: %s\nTitle: %s\nAuthor: %s\nDescription: %s\n\n", this.material, this.getTitle(), this.getAuthor(), this.getDescription());
	};
	
	
}
