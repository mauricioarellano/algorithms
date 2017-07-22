package com.wipro.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.wipro.test.exception.MaxBidReachedException;

public class BidderTest {
	
	public static int maxIncrement(Bidder bidder){
		int bid = 0;
		while(bid < 240){
			int nexBid;
			try {
				nexBid = bidder.incrementBid();
			} catch (MaxBidReachedException e) {
				break;
			}
			bid=nexBid;
		}
		System.out.println("Bid: " + bid);
		return bid;
	}

	@Test
	public void testMaxIncrement4LindaRecordPlayer() {
		int initial = 170;
		int maxBid = 240;
		int increment = 3;
		Bidder bidder = new Bidder("", new Offer(initial, maxBid, increment));
		int bid = maxIncrement(bidder);
		Assert.assertTrue(bid<=maxBid && bid>(maxBid-increment));
	}
	
	@Test
	public void testMaxIncrement4DaveRecordPlayer() {
		int initial = 160;
		int maxBid = 243;
		int increment = 7;
		Bidder bidder = new Bidder("", new Offer(initial, maxBid, increment));
		int bid = maxIncrement(bidder);
		Assert.assertTrue(bid<=maxBid && bid>(maxBid-increment));
	}

	@Test
	public void testMaxIncrement4EricRecordPlayer() {
		int initial = 190;
		int maxBid = 240;
		int increment = 4;
		Bidder bidder = new Bidder("", new Offer(initial, maxBid, increment));
		int bid = maxIncrement(bidder);
		Assert.assertTrue(bid<=maxBid && bid>(maxBid-increment));
	}

}
