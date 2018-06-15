package bowling.frame.impl;

public class StrikeFrame extends AbstractFrame {
	
	public static int STRIKE_VALUE = 10;
	
	public StrikeFrame() {
		
	}

	@Override
	public int getValue() {
		return STRIKE_VALUE + getNextFrame().getStrikeBonus();
	}
	
	@Override
	public boolean isStrike() {
		return true;
	}

	@Override
	public int getStrikeBonus() {
		return STRIKE_VALUE + getNextFrame().getSpareBonus();
	}

	@Override
	public int getSpareBonus() {
		return STRIKE_VALUE;
	}
	
}
