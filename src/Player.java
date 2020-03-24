/**
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
	 * hand containing two cards
	 */
	private ArrayList<Card> hand;
	
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
	
	
	public void setHand(ArrayList<Card> twoCards) {
		this.hand = twoCards;
	}
	
	public Hands findHand(ArrayList<Card> table) {
		
		ArrayList<Card> fullTable = new ArrayList();
		fullTable.addAll(this.hand);
		fullTable.addAll(table);
		
		Collections.sort(fullTable);
		
		//section to find flush
		boolean isFlush = false;
		
		int spades = 0;
		int clubs = 0;
		int diamonds = 0;
		int hearts = 0;
		
		for (int i = 0; i < table.size(); i++) {
			
			switch (table.get(i).getSuit()) {
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
			return Hands.FLUSH;
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
					
					//get length of straight by subractive highest number from lowest
					isStraight = j - currentNum;
				}
			}
			
		}
		
		if (isStraight >= 5) {
			return Hands.STRAIGHT;
		}
		
		//Section to find pair/3 of a kind/4 of a kinds
		
		
		return Hands.HIGH_CARD;
		
		}
		
	


}
