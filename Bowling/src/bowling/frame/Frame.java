package bowling.frame;

/**
 * Frame class acts as a linked list, calculating score as list is traversed
 * @author David
 */
public interface Frame {
	/**
	 * @return Returns the next frame in the linked list
	 */
	public Frame getNextFrame();
	/**
	 * Sets the next frame of the linked list
	 * @param nextFrame The next frame for the linked list.
	 */
	public void setNextFrame(Frame nextFrame);
	/**
	 * Calculates the value for this particular frame. May also utilize the next frames in the list if is a strike or spare.
	 * @return The value of this frame.
	 */
	public int getValue();
	/**
	 * Whether or not the frame was a strike.
	 * @return Whether or not this frame was a strike.
	 */
	public boolean isStrike();
	/**
	 * Whether or not the frame was a spare.
	 * @return Whether or not the frame was a spare.
	 */
	public boolean isSpare();
	/**
	 * Calculates this frame's contribution to the value of a previous strike.
	 * @return This frame's strike bonus.
	 */
	public int getStrikeBonus();
	/**
	 * Calculates this frame's contribution to the value of a previous spare.
	 * @return This frame's spare bonus.
	 */
	public int getSpareBonus();
	/**
	 * Traverses the entire linked list and calculates total score.
	 * @return Calculated total score for all frames.
	 */
	public int calculateScore();
}
