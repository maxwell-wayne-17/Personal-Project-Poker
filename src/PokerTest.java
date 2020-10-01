/**
 * 
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.*;

/**
 * Testing class for the poker program
 * @author Max Wayne
 *
 */
public class PokerTest {

	@Test
	public void testPrintCard1() {
		Card test = new Card();
		String actual = test.printCard();
		String expected = "0 of Hearts";
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testPrintCard2() {
		Card test = new Card(2, Suit.SPADES);
		String actual = test.printCard();
		String expected = "2 of Spades";
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testPrintCard3() {
		Card test = new Card(14, Suit.CLUBS);
		String actual = test.printCard();
		String expected = "14 of Clubs";
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testPrintCard4() {
		Card test = new Card(8, Suit.DIAMONDS);
		String actual = test.printCard();
		String expected = "8 of Diamonds";
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void compareCard1() {
		Card great = new Card(100000, Suit.SPADES);
		Card less = new Card(0, Suit.SPADES);
		
		int test = great.compareTo(less);
		
		boolean check = test > 0;
		boolean expected = true;
		
		assertEquals(expected, check);
		
	}
	
	@Test
	public void compareCard2() {
		Card great = new Card(0, Suit.SPADES);
		Card less = new Card(1000000, Suit.SPADES);
		
		int test = great.compareTo(less);
		
		boolean check = test > 0;
		boolean expected = false;
		
		assertEquals(expected, check);
		
	}
	
	@Test
	public void findFlush1() {
		Player test = new Player("max", 5000);
		
		ArrayList<Card> table = new ArrayList<Card>();
		for (int i = 1; i <= 5; i++) {
			Card temp = new Card(i, Suit.HEARTS);
			table.add(temp);
		}
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.CLUBS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		boolean actual = test.findFlush(table);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void findFlush2() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.SPADES);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.SPADES);
		table.add(three);
		Card four = new Card(10, Suit.SPADES);
		table.add(four);
		Card five = new Card(5, Suit.SPADES);
		table.add(five);
		Card six = new Card(12, Suit.CLUBS);
		table.add(six);
		Card seven = new Card(7, Suit.HEARTS);
		table.add(seven);
		
		boolean actual = test.findFlush(table);
		boolean expected = true;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findFlushFail1() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.HEARTS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.DIAMONDS);
		table.add(three);
		Card four = new Card(10, Suit.CLUBS);
		table.add(four);
		Card five = new Card(5, Suit.SPADES);
		table.add(five);
		Card six = new Card(12, Suit.HEARTS);
		table.add(six);
		Card seven = new Card(7, Suit.DIAMONDS);
		table.add(seven);
		
		boolean actual = test.findFlush(table);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findFlushFail2() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.SPADES);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.SPADES);
		table.add(three);
		Card four = new Card(10, Suit.SPADES);
		table.add(four);
		
		boolean actual = test.findFlush(table);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findFlushFail3() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.HEARTS);
		Card two = new Card(14, Suit.HEARTS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.HEARTS);
		table.add(three);
		Card four = new Card(10, Suit.HEARTS);
		table.add(four);
		
		boolean actual = test.findFlush(table);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findFlushFail4() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.DIAMONDS);
		Card two = new Card(14, Suit.DIAMONDS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.DIAMONDS);
		table.add(three);
		Card four = new Card(10, Suit.DIAMONDS);
		table.add(four);
		
		boolean actual = test.findFlush(table);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findFlushFail5() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.CLUBS);
		Card two = new Card(14, Suit.CLUBS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.CLUBS);
		table.add(three);
		Card four = new Card(10, Suit.CLUBS);
		table.add(four);
		
		boolean actual = test.findFlush(table);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void findStraight1() {
		
		Player test = new Player("max", 5000);
		

		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.CLUBS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(12, Suit.HEARTS);
		table.add(three);
		Card four = new Card(11, Suit.DIAMONDS);
		table.add(four);
		Card five = new Card(10, Suit.SPADES);
		table.add(five);
		Card six = new Card(2, Suit.CLUBS);
		table.add(six);
		Card seven = new Card(7, Suit.HEARTS);
		table.add(seven);
		
		boolean actual = test.findStraight(table);
		boolean expected = true;
		
		assertEquals(expected, actual);
		
			
	}
	
	@Test
	public void findStraight2() {
		
		Player test = new Player("max", 5000);
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.CLUBS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		ArrayList<Card> table = new ArrayList<Card>();
		Card three = new Card(3, Suit.HEARTS);
		table.add(three);
		Card four = new Card(4, Suit.DIAMONDS);
		table.add(four);
		Card five = new Card(5, Suit.SPADES);
		table.add(five);
		Card six = new Card(6, Suit.CLUBS);
		table.add(six);
		Card seven = new Card(7, Suit.HEARTS);
		table.add(seven);
		
		boolean actual = test.findStraight(table);
		boolean expected = true;
		
		assertEquals(expected, actual);
		
			
	}
	
	@Test
	public void findStrightFlush1() {
		
		Player test = new Player("max", 5000);
		
		ArrayList<Card> table = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			Card temp = new Card(i, Suit.HEARTS);
			table.add(temp);
		}
		
		Card one = new Card(13, Suit.SPADES);
		Card two = new Card(14, Suit.CLUBS);
		ArrayList<Card> twoCards = new ArrayList<Card>();
		twoCards.add(one);
		twoCards.add(two);
		
		test.setHand(twoCards);
		
		Hands actual = test.findHand(table);
		Hands expected = Hands.STRAIGHT_FLUSH;
		
		assertEquals(expected, actual);
		
			
	}
	
	
	
	
}
