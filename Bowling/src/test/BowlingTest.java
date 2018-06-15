package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import bowling.BowlingGame;

public class BowlingTest {

	@Test
	public void StrikeTest() {
		BowlingGame game = new BowlingGame("XXXXXXXXXXXX");
		assertEquals(300, game.calculateScore());
	}
	
	@Test
	public void NormalWithMissesTest() {
		BowlingGame game = new BowlingGame("9-9-9-9-9-9-9-9-9-9-");
		assertEquals(90, game.calculateScore());
	}
	
	@Test
	public void SpareTest() {
		BowlingGame game = new BowlingGame("5/5/5/5/5/5/5/5/5/5/5");
		assertEquals(150, game.calculateScore());
	}
	
	@Test
	public void MixedTest() {
		BowlingGame game = new BowlingGame("X7/9-X-88/-6XXX81");
		assertEquals(167, game.calculateScore());
	}
}
