package com.wipro.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuctionTest {

	@Test
	public void testAuctionOne() {
		Auction auction = new Auction("Record player");
		Bidder linda = new Bidder("Linda", new Offer(170, 240, 3));
		Bidder dave =  new Bidder("Dave",  new Offer(160, 243, 7));
		Bidder eric =  new Bidder("Eric",  new Offer(190, 240, 4));
		
		auction.addBidder(linda);
		auction.addBidder(dave);
		auction.addBidder(eric);
		
		Bidder winner = auction.executeAuction();
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
	}

	@Test
	public void testAuctionTwo() {
		Auction auction = new Auction("Snow shoes");
		Bidder linda = new Bidder("Linda", new Offer(30, 70, 4));
		Bidder dave =  new Bidder("Dave",  new Offer(30, 70, 3));
		Bidder eric =  new Bidder("Eric",  new Offer(40, 90, 2));
		
		auction.addBidder(linda);
		auction.addBidder(dave);
		auction.addBidder(eric);
		
		Bidder winner = auction.executeAuction();
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
	}

	@Test
	public void testAuctionThree() {
		Auction auction = new Auction("Piano");
		Bidder linda = new Bidder("Linda", new Offer(20_000, 65_000,  2_000));
		Bidder dave =  new Bidder("Dave",  new Offer(10_000, 70_000, 15_000));
		Bidder eric =  new Bidder("Eric",  new Offer(22_000, 70_000,  8_000));
		
		auction.addBidder(linda);
		auction.addBidder(dave);
		auction.addBidder(eric);
		
		Bidder winner = auction.executeAuction();
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
	}

}
