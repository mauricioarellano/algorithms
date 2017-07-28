package com.wipro.test;

import org.junit.Assert;
import org.junit.Test;

import com.wipro.test.entities.Bidder;
import com.wipro.test.entities.Offer;

public class BidderTest {
	
	@Test
	public void testValidIncrement() {
		int initial = 190;
		int maxBid = 240;
		int increment = 4;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		bidder.improveBid(193);
		System.out.println(bidder);
		Assert.assertEquals(194, bidder.getBid());
	}
	
	@Test
	public void testValidMaximIncrement() {
		int initial = 190;
		int maxBid = 200;
		int increment = 10;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		bidder.improveBid(201);
		System.out.println(bidder);
		Assert.assertEquals(maxBid, bidder.getBid());
	}
	
	@Test
	public void testInvalidIncrement() {
		int initial = 190;
		int maxBid = 200;
		int increment = 11;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		bidder.improveBid(300);
		System.out.println(bidder);
		Assert.assertEquals(190, bidder.getBid());
	}

	
	@Test
	public void testImproveBid() {
		int initial = 234;// 190;
		int maxBid = 240;
		int increment = 4;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		int expected = 238;
		int actual = bidder.improveBid(237);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testImproveBidMax() {
		int initial = 234;// 190;
		int maxBid = 240;
		int increment = 4;
		int currentBid = 300;
		Bidder bidder = new Bidder("Test", new Offer(initial, maxBid, increment));
		int expected = 238;
		int actual = bidder.improveBid(currentBid);
		Assert.assertEquals(expected, actual);
	}
}
