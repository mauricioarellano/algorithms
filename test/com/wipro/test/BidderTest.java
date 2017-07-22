package com.wipro.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.wipro.test.exception.MaxBidReachedException;

public class BidderTest {
	
	@Test
	public void testValidIncrement() {
		int initial = 190;
		int maxBid = 240;
		int increment = 4;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		try {
			bidder.incrementBid();
		} catch (MaxBidReachedException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.getMessage());
		}
		System.out.println(bidder);
		Assert.assertEquals(194, bidder.getBid());
	}
	
	@Test
	public void testValidMaximIncrement() {
		int initial = 190;
		int maxBid = 200;
		int increment = 10;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		try {
			bidder.incrementBid();
		} catch (MaxBidReachedException e) {
			// TODO Auto-generated catch block
			Assert.fail(e.getMessage());
		}
		System.out.println(bidder);
		Assert.assertEquals(maxBid, bidder.getBid());
	}
	
	@Test
	public void testInvalidIncrement() {
		int initial = 190;
		int maxBid = 200;
		int increment = 11;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		try {
			bidder.incrementBid();
		} catch (MaxBidReachedException e) {
			System.out.println("maxBid reached without increment");
		}
		System.out.println(bidder);
		Assert.assertEquals(190, bidder.getBid());
	}

}
