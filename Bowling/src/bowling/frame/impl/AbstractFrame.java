package bowling.frame.impl;

import bowling.frame.Frame;

public abstract class AbstractFrame implements Frame {

	protected Frame nextFrame;
	
	@Override
	public Frame getNextFrame() {
		return nextFrame;
	}

	@Override
	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
		
	}
	
	@Override
	public boolean isStrike() {
		return false;
	}
	
	@Override
	public boolean isSpare() {
		return false;
	}
	
	@Override
	public int calculateScore() {
		if (null == getNextFrame()) {
			return getValue();
		}
		return getValue() + getNextFrame().calculateScore();
	}

}
