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
	
	
}
