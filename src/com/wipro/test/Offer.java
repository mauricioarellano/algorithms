package com.wipro.test;

public class Offer {
	private int startingBid;
	private int maxBid;
	private int autoIncrementAmount;
	
	public Offer(int startingBid, int maxBid, int autoIncrementAmount) {
		this.startingBid = startingBid;
		this.maxBid = maxBid;
		this.autoIncrementAmount = autoIncrementAmount;
	}
	
	
	public int getStartingBid() {
		return startingBid;
	}


	public int getMaxBid() {
		return maxBid;
	}


	public int getAutoIncrementAmount() {
		return autoIncrementAmount;
	}


	@Override
	public String toString() {
		return "Offer [startingBid=" + startingBid + ", maxBid=" + maxBid + ", autoIncrementAmount=" + autoIncrementAmount + "]";
	}
	
	
}
