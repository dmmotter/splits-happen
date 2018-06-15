package bowling;

import bowling.frame.Frame;
import bowling.frame.impl.BonusFrame;
import bowling.frame.impl.NormalFrame;
import bowling.frame.impl.SpareFrame;
import bowling.frame.impl.StrikeFrame;

/**
 * Class representing one single bowling game. Supports a valid game only per document, no validation done.
 * @author David
 *
 */
public class BowlingGame {
	public static char STRIKE = 'X';
	public static char SPARE = '/';
	public static char MISS = '-';
	public static int STRIKE_VALUE = 10;
	public static int MISS_VALUE = 0;
	
	Frame rootFrame;
	
	public BowlingGame(String game) {
		parseGame(game);
	}
	
	/**
	 * Parse the input game and populate the Frame linked list.
	 * @param game Valid game input (no validation)
	 */
	private void parseGame(String game){
		char[] gameArray = game.toCharArray();
		Frame previousFrame = null;
		
		for (int i = 0; i < gameArray.length; i++) {
			Frame frame = calculateFrame(gameArray, i, previousFrame);
		
			if (null != previousFrame) {
				previousFrame.setNextFrame(frame);
			}
			if (null == rootFrame) {
				rootFrame = frame; //Set root frame to first frame found as head of linked list
			}
			
			previousFrame = frame;
			
			if (!frame.isStrike()) {
				i++; //If it's not a strike, move i forward 1 since next shot was already calculated
			}
		}
	}
	
	/**
	 * Calculates the type of an individual frame using the current value of i and possibly i + 1 based on if i is a strike.
	 * @param gameArray The array of game outcomes.
	 * @param i The current index of the given array.
	 * @param previousFrame The frame for the previous index of i.
	 * @return Frame representation of i and possibly i + 1 depending on the value of i.
	 */
	private Frame calculateFrame(char[] gameArray, int i, Frame previousFrame) {
		if (i == gameArray.length - 2 && previousFrame.isStrike()) { //If 2 frames remaining and there is a strike, the 2 remaining frames must be bonus rolls.
			return new BonusFrame(getBowlValue(gameArray[i]), getBowlValue(gameArray[i + 1]));
		}
		else if (i == gameArray.length - 1 && previousFrame.isSpare()) { //If 1 frame remaining and there is a spare, the remaining frame must be a bonus roll.
			return new BonusFrame(getBowlValue(gameArray[i]));
		}
		else if (STRIKE == gameArray[i]) {
			return new StrikeFrame();
		}
		else {
			if (SPARE == gameArray[i + 1]) { //Per doc, not checking for invalid # of rolls here
				return new SpareFrame(getBowlValue(gameArray[i]));
			}
			else {
				return new NormalFrame(getBowlValue(gameArray[i]), getBowlValue(gameArray[i + 1]));
			}
		}
	}
	
	/**
	 * Calculates the bowl value of a given character. Spares are not supported (no validation done per doc)
	 * @param bowl The input bowl outcome.
	 * @return Point value of the bowl attempt.
	 */
	private int getBowlValue(char bowl) {
		if (MISS == bowl) {
			return MISS_VALUE;
		}
		else if (STRIKE == bowl) {
			return STRIKE_VALUE;
		}
		else {
			return Character.getNumericValue(bowl);
		}
	}
	
	/**
	 * Calculate score using the calculation method of the Frame interface
	 * @return The total score for the given game
	 */
	public int calculateScore() {
		return rootFrame.calculateScore();
	}
}
