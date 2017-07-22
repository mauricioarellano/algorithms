package com.wipro.test;

import java.util.ArrayList;
import java.util.List;

import com.wipro.test.exception.MaxBidReachedException;

public class Auction  {
	private String item;
	private List<Bidder> bidders;
		
	public Auction() {
		this.bidders = new ArrayList<Bidder>();
	}
	
	public Auction(String item) {
		this();
		this.item = item;
	}
	
	public void addBidder(Bidder bidder){
		bidders.add(bidder);
	}
	
	public Bidder executeAuction(){
		if(bidders.isEmpty()){
			return null;
		}
		
		int currentBid = 0;
		Bidder currentBidder = null;
		//System.out.println("currentBid: " + currentBid);
		
		while(bidders.size()>1){
			List<Bidder> biddersAux = new ArrayList<Bidder>(bidders);
			for (Bidder bidder : bidders) {
				try {
					System.out.println("current bid: " + currentBid + "; " + bidder);
					if(currentBid < bidder.getBid()){
						currentBid = bidder.getBid();
						currentBidder = bidder;
						System.out.println("new bid: " + currentBid + "; " + bidder);
					} else if(currentBid >= bidder.getBid() && !bidder.equals(currentBidder)){
						if(currentBid > bidder.getOffer().getMaxBid()){
							throw new MaxBidReachedException();
						} 
						bidder.incrementBid();
						if(currentBid < bidder.getBid()){
							currentBid = bidder.getBid();
							currentBidder = bidder;
							System.out.println("new bid: " + currentBid + "; " + bidder);
						}
					}
					
					//System.out.println("bid: " + currentBid + "; " + bidder);
				} catch (MaxBidReachedException e) {
					biddersAux.remove(bidder);
					System.out.println("Deleted: " + bidder);
				}
			}
			bidders = biddersAux;
		}
		
		return bidders.get(0);
	}

	@Override
	public String toString() {
		return "Auction [item=" + item + "]";
	}
	
	
}
