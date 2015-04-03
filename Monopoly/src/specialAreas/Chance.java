package specialAreas;

import game.Player;

import java.util.HashMap;
import java.util.HashSet;



import positioning.Coordinate;
import properties.Location;
import luckyCards.*;
public class Chance extends SpecialArea implements Location {

	private Card[] cards;
	
	public Chance(Coordinate _coordinate){
		super(_coordinate);
		cards = new Card[10];
		int i = 0;
		cards[i++]= new Card("Parking fine",-100);
		cards[i++]= new Card("Pay poor tax",-200);
		cards[i++]= new Card("Pay School tax",-150);
		cards[i++]= new Card("Pay insurance premium",-100);
		cards[i++]= new Card("Street repairs",-145);
		cards[i++]= new Card("It's your birthday!",100);
		cards[i++]= new Card("Money for services",200);
		cards[i++]= new Card("Life insurance matures!",150);
		cards[i++]= new Card("Grand opera night",145);
		cards[i++]= new Card("You won a crossword competition",100);
	
	}
	public String name() {
		return "Chance";
	}
	public String toString(){
		return "You get a chance card.";
	}
	public String printOption(Player currentPlayer) {
		return null;
	}
	public String autoAction(Player currentPlayer) {
		int cardIdx = (int)(10*Math.random());
		Card chosenCard = cards[cardIdx];
		
		String returnString = chosenCard.getDescription();
		if(chosenCard.getMoneyValue()<0){returnString = returnString + "\nYou lose $"+(Math.abs(chosenCard.getMoneyValue()));
		currentPlayer.deduct(Math.abs(chosenCard.getMoneyValue()));}
		else {returnString = returnString + "\nYou get $"+chosenCard.getMoneyValue()+"!";
		currentPlayer.add(chosenCard.getMoneyValue());}
		return returnString;
	}




}
