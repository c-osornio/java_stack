package com.codingdojo.abstractart;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		Painting monaLisa = new Painting("Oil Paint", "Mona Lisa", "Leonardo da Vinci", "The piece features a portrait of a seated woman set against an imaginary landscape. In addition to being one of the most famous paintings, it is also the most valuable." );
		Painting americanGothic = new Painting("Oil Paint" ,"American Gothic" ,"Grant Wood" ,"Painting depicts a woman dressed in colonial print apron evoking 19th-century Americana and a man holding a pitchfork");
		Painting theStarryNight = new Painting("Oil Paint", "The Starry Night", "Vincent van Gogh", "Depicts the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence, just before sunrise, with the addition of an imaginary village." );
		
		Sculpture theThinker = new Sculpture("Bronze", "The Thinker", "Auguste Rodin", "The work depicts a nude male figure of heroic size sitting on a rock.");
		Sculpture theGreatSphinx = new Sculpture("LimeStone", "The Great Sphinx", "King Khafre", "Statue of a reclining sphinx, a mythical creature with the head of a human, and the body of a lion.");
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(monaLisa);
		museum.add(americanGothic);
		museum.add(theStarryNight);
		museum.add(theThinker);
		museum.add(theGreatSphinx);
		
		Collections.shuffle(museum);
		
		for(Art artwork : museum) {
			artwork.viewArt();
		}
	}

}
