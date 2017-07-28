package com.wipro.test;

import java.util.List;

import com.wipro.test.entities.Bidder;

public interface Auctioneer {

	Bidder executeAuction(List<Bidder> biddersList);

	Bidder executeAuction(List<Bidder> biddersList, int startingBid);
	
}