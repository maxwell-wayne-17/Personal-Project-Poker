/**
 * Card Object
 * @author maxwn
 *
 */
public class Card implements Comparable<Card>{

	/**
	 * Number value of card
	 */
	private int number;
	
	/**
	 * Indicator of if card is already dealt
	 */
	private boolean isDealt;
	
	/**
	 * Suit of the card
	 */
	private Suit type;
	
	/**
	 * Default constructor that makes a dealt 0 of Hearts
	 */
	public Card() {
		this.number = 0;
		this.isDealt = true;
		this.type = Suit.HEARTS;
	}
	
	/**
	 * Two parameter constructor that sets number and suit, isDealt will be false
	 * @param num input number of the card
	 * @param suit input suit of the card
	 */
	public Card(int num, Suit suit) {
		this.number = num;
		this.type = suit;
		this.isDealt = false;
	}
	
	/**
	 * allows change of the isDealt variable
	 * @param dealt boolean value if card is dealt
	 */
	public void setDealt(boolean dealt) {
		this.isDealt = dealt;
	}
	
	/**
	 * getter for suit
	 * @return suit of card
	 */
	public Suit getSuit() {
		return this.type;
	}
	
	/**
	 * getter for number value of card
	 * @return number value of card
	 */
	public int getNum() {
		return this.number;
	}
	
	/**
	 * prints the card
	 * @return "num" of "suit"
	 */
	public String printCard() {
		
		String cardName = "did not work";
		
		switch (this.type) {
		
		case SPADES:
			cardName = this.number + " of Spades";
			return cardName;
		
		case CLUBS:
			cardName = this.number + " of Clubs";
			return cardName;
			
		case DIAMONDS:
			cardName = this.number + " of Diamonds";
			return cardName;
			
		case HEARTS:
			cardName = this.number + " of Hearts";
			return cardName;
		
		default:
			return cardName;		
		
		}
		
		
		
	}

	/**
	 * comparable override method
	 */
	@Override
	public int compareTo(Card o) {
		return this.number - o.getNum();
	}
	
	
}
