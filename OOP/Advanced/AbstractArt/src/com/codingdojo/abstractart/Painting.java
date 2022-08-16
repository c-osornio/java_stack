package com.codingdojo.abstractart;

public class Painting extends Art {
	private String  paintType;
	
	public Painting(String paintType, String title, String author, String description) {
		super(title, author, description);
		this.setPaintType(paintType);
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		System.out.printf("\nPaint Type: %s\nTitle: %s\nAuthor: %s\nDescription: %s\n\n", this.paintType, this.getTitle(), this.getAuthor(), this.getDescription());
	};
	
	
}
