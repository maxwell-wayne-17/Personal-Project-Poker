/**
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Class representing a player in the poker game
 * @author Max Wayne
 *
 */
public class Player {
	
	/**
	 * name of player
	 */
	private String name;
	
	/**
	 * Total chip amount owned by the player
	 */
	private int chipAmount;
	
	/**
	 * Current bet placed by player
	 */
	private int betAmount;
	
	/**
	 * folded or not
	 */
	private boolean isFolded;
	
	/**
	 * in hand or not
	 */
	private boolean inHand;
	
	/**
	 * is dealer or not
	 */
	private boolean isDealer;
	
	/**
	 * individual's hand containing two cards
	 */
	private ArrayList<Card> hand;
	
	/**
	 * Best combination of cards
	 */
	private Hands bestHand;
	
	/**
	 * Default constructor
	 */
	public Player() {
		
		this.name = "default";
		this.chipAmount = 0;
		this.betAmount = 0;
		this.isFolded = false;
		this.inHand = true;
		this.isDealer = false;
		this.bestHand = Hands.HIGH_CARD;
		
	}
	
	/**
	 * Two parameter constructor
	 * @param user name of user
	 * @param buyIn amount of chips to play with
	 */
	public Player(String user, int buyIn) {
		
		this.name = user;
		this.chipAmount = buyIn;
		this.betAmount = 0;
		this.isFolded = false;
		this.inHand = true;
		this.isDealer = false;
		this.bestHand = Hands.HIGH_CARD;
		
	}
	
	/**
	 * Places a bet by removing chips and increasing bet amount
	 * @param bet bet to place
	 * @return bet placed
	 */
	public int placeBet(int bet) {
		this.chipAmount = chipAmount - bet;
		this.betAmount = betAmount + bet;
		return bet;
	}
	
	/**
	 * sets fold to true
	 */
	public void fold() {
		this.isFolded = true;
	}
	
	/**
	 * adds chips if player wins pot
	 * @param pot amount of chips won
	 */
	public void addChips(int pot) {
		this.chipAmount = chipAmount + pot;
	}
	
	/**
	 * resets player at the end of the hand
	 */
	public void reset() {
		
		this.betAmount = 0;
		this.isFolded = false;
		this.isDealer = false;
		
		ArrayList<Card> empty = new ArrayList<Card>();
		this.hand = empty;
		
		
	}
	
	/**
	 * Returns player's best current hand
	 * @return player's current hand
	 */
	public Hands getHand() {
		return this.bestHand;
	}
	
	/**
	 * Setter to set the two cards dealt to the player
	 * @param twoCards Two cards dealt to player
	 */
	public void setHand(ArrayList<Card> twoCards) {
		this.hand = twoCards;
	}
	
	/**
	 * Method used to steamline setting up the player's hand to be checked
	 * @param table cards on the table to combine to player's two cards in hand
	 * @return array player's sorted playable cards
	 */
	public ArrayList<Card> setFullTable(ArrayList<Card> table) {
		
		ArrayList<Card> fullTable = new ArrayList<Card>();
		fullTable.addAll(this.hand);
		fullTable.addAll(table);
		
		Collections.sort(fullTable);
		
		return fullTable;
		
	}
	
	/**
	 * CHANGE TO PRIVATE LATER
	 * Checks full hand for flush
	 * @param table player's hand and cards on table
	 * @return true if flush, false if not
	 */
	public boolean findFlush(ArrayList<Card> table) {
		
		ArrayList<Card> fullTable = this.setFullTable(table);
		
		boolean isFlush = false;
		
		int spades = 0;
		int clubs = 0;
		int diamonds = 0;
		int hearts = 0;
		
		for (int i = 0; i < fullTable.size(); i++) {
			
			switch (fullTable.get(i).getSuit()) {
			case SPADES:
				spades++;
				break;
			
			case CLUBS:
				clubs++;
				break;
				
			case DIAMONDS:
				diamonds++;
				break;
				
			case HEARTS:
				hearts++;
				break;
			
			default:
				break;		
			
			}
		}
		
		if (spades >= 5 || clubs >= 5 || diamonds >= 5 || hearts >= 5) {
			isFlush = true;
		}
		
		return isFlush;
	}
	
	/** MAKE PUBLIC EVENTUALLY
	 * Checks full hand for straight
	 * @param table player's hand and cards on table
	 * @return true if straight on board, false if not
	 */
	public boolean findStraight(ArrayList<Card> table) {
		
		ArrayList<Card> fullTable = this.setFullTable(table);
		
		int isStraight = 0; //must be >= 5 for straight
		
		//has all card numbers
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < fullTable.size(); ++i) {
			numbers.add(fullTable.get(i).getNum());
		}
		
		for (int i = 0; i < fullTable.size(); i++) {
			
			int currentNum = fullTable.get(i).getNum();
			
			if (numbers.contains(currentNum)) {
				//j becomes consecutive numbers and checks hash table
				int j = currentNum;
				while (numbers.contains(j)) {
					j++;
				}
				
				if (isStraight < j - currentNum) {
					
					//get length of straight by subracting highest number from lowest
					isStraight = j - currentNum;
				}
			}
			
		}
		
		return (isStraight >= 5) ?  true :  false;
	}
	
	
	/**
	 * Checks full hand for full house
	 * @param table player's hand and cards on table
	 * @return true if full house on board, false if not
	 */
	private boolean findFullHouse(ArrayList<Card> table) {
		return false;
	}
	
	/**
	 * Checks full hand for quads, triples, or pairs
	 * @param table player's hand and cards on table
	 * @return Highest reoccurance of a card
	 */
	private int findRepats(ArrayList<Card> table) {
		return 1;
	}
	
	/**
	 * Checks full hand for two pair
	 * @param table player's hand and cards on table
	 * @return true if two pair on board, false if not
	 */
	private boolean findTwoPair(ArrayList<Card> table) {
		return false;
	}
	
	public Hands findHand(ArrayList<Card> table) {
		
		ArrayList<Card> fullTable = new ArrayList<Card>();
		fullTable.addAll(this.hand);
		fullTable.addAll(table);
		
		Collections.sort(fullTable);
		
		//section to find flush
		boolean isFlush = false;
		
		int spades = 0;
		int clubs = 0;
		int diamonds = 0;
		int hearts = 0;
		
		for (int i = 0; i < fullTable.size(); i++) {
			
			switch (fullTable.get(i).getSuit()) {
			case SPADES:
				spades++;
				break;
			
			case CLUBS:
				clubs++;
				break;
				
			case DIAMONDS:
				diamonds++;
				break;
				
			case HEARTS:
				hearts++;
				break;
			
			default:
				break;		
			
			}
		}
		
		if (spades >= 5 || clubs >= 5 || diamonds >= 5 || hearts >= 5) {
			isFlush = true;
		}
			
		
		//Section to find straight
		int isStraight = 0; //must be >= 5 for straight
		
		//has all card numbers
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < fullTable.size(); ++i) {
			numbers.add(fullTable.get(i).getNum());
		}
		
		for (int i = 0; i < fullTable.size(); i++) {
			
			int currentNum = fullTable.get(i).getNum();
			
			if (numbers.contains(currentNum)) {
				//j becomes consecutive numbers and checks hash table
				int j = currentNum;
				while (numbers.contains(j)) {
					j++;
				}
				
				if (isStraight < j - currentNum) {
					
					//get length of straight by subracting highest number from lowest
					isStraight = j - currentNum;
				}
			}
			
		}
		
		if (isFlush && isStraight >= 5) {
			return Hands.STRAIGHT_FLUSH;
		}
		
		//Section to find pair/3 of a kind/4 of a kinds
		HashMap<Integer, Integer> repeats = new HashMap<>();
		
		for (int i = 0; i < fullTable.size(); i++) {
			
			int currentNum = fullTable.get(i).getNum();
			repeats.put(currentNum, 1);
			
		}
		
		boolean quads = false;
		boolean trips = false;
		boolean fullHouse = false;
		boolean pair = false;
		
		if (repeats.containsValue(4)) {
			quads = true;
			//return Hands.FOUR_OF_A_KIND;
		}
		else if(repeats.containsValue(3) && repeats.containsValue(2)) {
			fullHouse = true;
			//return Hands.FULL_HOUSE;
		}
		else if(repeats.containsValue(3)) {
			trips = true;
			//return Hands.THREE_OF_A_KIND;
		}
		else if (repeats.containsValue(2)) {
			pair = true;
			//return Hands.PAIR;
		}
		
		if (quads == true) {
			return Hands.FOUR_OF_A_KIND;
		}
		else if (fullHouse == true) {
			return Hands.FULL_HOUSE;
		}
		else if (isFlush == true) {
			return Hands.FLUSH;
		}
		else if (isStraight >= 5) {
			return Hands.STRAIGHT;
		}
		else if (trips == true) {
			return Hands.THREE_OF_A_KIND;
		}
		//STILL NEED TWO PAIR
		else if (pair == true) {
			return Hands.PAIR;
		}
		else {
			return Hands.HIGH_CARD;
		}
		
	
		
		}
		
	


}
