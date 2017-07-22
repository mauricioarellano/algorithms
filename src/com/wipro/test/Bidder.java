package com.wipro.test;

import com.wipro.test.exception.MaxBidReachedException;

public class Bidder {
	private String name;
	private Offer offer;
	private int bid;
	
	public Bidder(String name, Offer offer) {
		this.name = name;
		this.offer = offer;
		bid = offer.getStartingBid();
	}
		
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public int getBid(){
		return bid;
	}
	
	public int incrementBid() throws MaxBidReachedException{
		int nexBid = nextBid();
		if(bid == nexBid){
			throw new MaxBidReachedException();
		}
		bid = nexBid;
		return bid;
	}

	private int nextBid() {
		if((bid+offer.getAutoIncrementAmount())<=offer.getMaxBid()){
			return bid + offer.getAutoIncrementAmount();
		}
		return bid;
	}

	@Override
	public String toString() {
		return "Bidder [name=" + name + ", bid=" + bid + ", offer=" + offer + "]";
	}
	
	
}
