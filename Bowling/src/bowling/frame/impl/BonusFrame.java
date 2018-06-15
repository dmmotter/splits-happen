package bowling.frame.impl;

public class BonusFrame extends NormalFrame {
	
	public BonusFrame(int firstBowl, int secondBowl) {
		super(firstBowl, secondBowl);
	}
	
	public BonusFrame(int firstBowl) {
		this(firstBowl, 0);
	}

	@Override
	public int getValue() {
		return 0; //Bonus frame has no value, only has strike bonus/spare bonus depending on last real frame
	}

}
