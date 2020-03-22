/**
 * 
 */
import java.util.ArrayList;


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
	private ArrayList<Card> hand = new ArrayList<Card>(2);
	
	public Player() {
		
		this.chipAmount = 0;
		this.betAmount = 0;
		this.isFolded = false;
		this.inHand = true;
		this.isDealer = false;
		
	}
	
	public Player(int buyIn) {
		
		this.chipAmount = buyIn;
		this.betAmount = 0;
		this.isFolded = false;
		this.inHand = true;
		this.isDealer = false;
		
	}
	
	public int placeBet(int bet) {
		this.chipAmount = chipAmount - bet;
		this.betAmount = betAmount + bet;
		return bet;
	}
	
	public void fold() {
		this.isFolded = true;
	}
	
	public void addChips(int pot) {
		this.chipAmount = chipAmount + pot;
	}
	
	public Hands findHand(ArrayList<Card> table) {
		
		return Hands.FLUSH;
		
	}
	


}
