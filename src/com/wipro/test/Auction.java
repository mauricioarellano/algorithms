package com.wipro.test;

import java.util.ArrayList;
import java.util.List;

import com.wipro.test.exception.MaxBidReachedException;

public class Auction  {
	private String item;
		
	public Auction(String item) {
		this.item = item;
	}
	
	public Bidder executeAuction(List<Bidder> biddersList){
		if(biddersList==null || biddersList.isEmpty()){
			return null;
		}
		
		int currentBid = 0;
		Bidder currentBidder = null;
		
		while(biddersList.size()>1){
			List<Bidder> biddersAux = new ArrayList<Bidder>(biddersList);
			for (Bidder bidder : biddersList) {
				try {
					if(currentBid < bidder.getBid()){
						currentBid = bidder.getBid();
						currentBidder = bidder;
					} else if(currentBid >= bidder.getBid() && !bidder.equals(currentBidder)){
						if(currentBid > bidder.getOffer().getMaxBid()){
							throw new MaxBidReachedException();
						}
						bidder.incrementBid();
						if(currentBid < bidder.getBid()){
							currentBid = bidder.getBid();
							currentBidder = bidder;
						}
					}
				} catch (MaxBidReachedException e) {
					biddersAux.remove(bidder);
				}
			}
			biddersList = biddersAux;
		}
		
		return biddersList.get(0);
	}

	@Override
	public String toString() {
		return "Auction [item=" + item + "]";
	}
	
}
