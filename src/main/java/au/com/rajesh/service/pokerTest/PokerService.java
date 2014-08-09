package au.com.rajesh.service.pokerTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.rajesh.model.pokerTest.Card;

@Service
public class PokerService {
	
	private static final Integer CARDS_MAX_LIMIT =40;
	
	enum Suit {Spades, Hearts, Diamonds, Clubs};
	enum Face { 
		ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10");
		
		private String name;
		
		Face(String name){
			this.name =name;
		}
		
		String getName(){
			return this.name;
		}
	};
	
	public List<Card> getDeck(Integer size){	
		
		if(size > CARDS_MAX_LIMIT){
			//Set appropriate error code, for the front end to handle
			throw new ServiceException("5001", "Requested cards size is more than the limit");
		}
		List<Card> deck = new ArrayList<Card>();		
		for (Suit suit : Suit.values()) {
            for (Face face: Face.values()) {
            	deck.add(new Card(suit.name(), face.name));
            }
        }
		// shuffle the deck
		Collections.shuffle(deck);	
		// Return the requested cards
		return deck.subList(0, size);
	}
}
