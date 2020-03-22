/**
 * 
 */

import static org.junit.Assert.assertEquals;
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
	
	
}
