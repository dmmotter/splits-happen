package bowling.frame.impl;

public class NormalFrame extends AbstractFrame {
	
	protected int firstBowl;
	protected int secondBowl;

	public NormalFrame(int firstBowl, int secondBowl) {
		this.firstBowl = firstBowl;
		this.secondBowl = secondBowl;
	}
	
	@Override
	public int getValue() {
		return firstBowl + secondBowl;
	}

	@Override
	public int getStrikeBonus() {
		return firstBowl + secondBowl;
	}

	@Override
	public int getSpareBonus() {
		return firstBowl;
	}

	
}
