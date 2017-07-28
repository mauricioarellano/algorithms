package com.wipro.test;

import java.util.ArrayList;
import java.util.List;

import com.wipro.test.entities.Bidder;

public class Auction implements Auctioneer  {
	private String item;
		
	public Auction(String item) {
		this.item = item;
	}

	@Override
	public Bidder executeAuction(List<Bidder> biddersList){
		return executeAuction(biddersList, 0);
	}

	@Override
	public Bidder executeAuction(List<Bidder> biddersList, int startingBid) {
		if(biddersList==null || biddersList.isEmpty()){
			return null;
		}
		
		Bidder currentBidder = null; 
		int currentBid = startingBid;
		
		while(biddersList.size()>1){
			List<Bidder> biddersAux = new ArrayList<Bidder>(biddersList);
			for (Bidder bidder : biddersList) {
				if(bidder.getBid() > currentBid){
					currentBidder = bidder;
					currentBid = currentBidder.getBid();
				} else if(currentBid >= bidder.getBid() && !bidder.equals(currentBidder)){
					if(currentBid > bidder.getOffer().getMaxBid()){
						biddersAux.remove(bidder);
					} else {
						bidder.improveBid(currentBid);
						if(currentBid < bidder.getBid()){
							currentBid = bidder.getBid();
							currentBidder = bidder;
						} else {
							biddersAux.remove(bidder);
						}	
					}
				}
			}
			biddersList = biddersAux;
		}
		
		if(biddersList.isEmpty()){
			return null;
		}
		
		return biddersList.get(0);
	}

	@Override
	public String toString() {
		return "Auction [item=" + item + "]";
	}
	
}
