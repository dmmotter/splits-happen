package bowling.frame.impl;

public class SpareFrame extends AbstractFrame {
	
	public static int SPARE_VALUE = 10;

	protected int firstBowl;
	
	public SpareFrame(int firstBowl) {
		this.firstBowl = firstBowl;
	}
	
	@Override
	public int getValue() {
		return SPARE_VALUE + getNextFrame().getSpareBonus();
	}

	@Override
	public int getStrikeBonus() {
		return SPARE_VALUE;
	}

	@Override
	public int getSpareBonus() {
		return firstBowl;
	}
	
	@Override
	public boolean isSpare() {
		return true;
	}
	
	
}
