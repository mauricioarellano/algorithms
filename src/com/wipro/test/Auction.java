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
		if(biddersList==null || biddersList.isEmpty()){
			return null;
		}
		
		Bidder currentBidder = biddersList.get(0);
		int currentBid = currentBidder.getBid();;
		
		while(biddersList.size()>1){
			List<Bidder> biddersAux = new ArrayList<Bidder>(biddersList);
			for (Bidder bidder : biddersList) {
				if(currentBid >= bidder.getBid() && !bidder.equals(currentBidder)){
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
		
		return biddersList.get(0);
	}

	@Override
	public String toString() {
		return "Auction [item=" + item + "]";
	}
	
}
