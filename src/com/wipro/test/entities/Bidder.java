package com.wipro.test.entities;

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

	public int getBid(){
		return bid;
	}
	
	public int improveBid(int currentBid) {
		int newBid=bid;
		
		while(newBid<=currentBid && newBid<=offer.getMaxBid()){
			newBid += offer.getAutoIncrementAmount();
			if(newBid <= offer.getMaxBid()){
				bid=newBid;
			}
		}
		
		return bid;
	}

	@Override
	public String toString() {
		return "Bidder [name=" + name + ", bid=" + bid + ", offer=" + offer + "]";
	}
	
	
}
