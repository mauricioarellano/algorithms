package com.wipro.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AuctionTest {

	@Test
	public void testAuctionOne() {
		Auction auction = new Auction("Record player");
		Bidder linda = new Bidder("Linda", new Offer(170, 240, 3));
		Bidder dave =  new Bidder("Dave",  new Offer(160, 243, 7));
		Bidder eric =  new Bidder("Eric",  new Offer(190, 240, 4));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
		assertNotNull(winner);
		assertEquals(linda, winner);
	}

	@Test
	public void testAuctionTwo() {
		Auction auction = new Auction("Snow shoes");
		Bidder linda = new Bidder("Linda", new Offer(30, 70, 4));
		Bidder dave =  new Bidder("Dave",  new Offer(30, 70, 3));
		Bidder eric =  new Bidder("Eric",  new Offer(40, 90, 2));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
		assertNotNull(winner);
		assertEquals(eric, winner);
	}

	@Test
	public void testAuctionThree() {
		Auction auction = new Auction("Piano");
		Bidder linda = new Bidder("Linda", new Offer(20_000, 65_000,  2_000));
		Bidder dave =  new Bidder("Dave",  new Offer(10_000, 70_000, 15_000));
		Bidder eric =  new Bidder("Eric",  new Offer(22_000, 70_000,  8_000));
		
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner.toString() + " ==\n");
		assertNotNull(winner);
		assertEquals(dave, winner);
	}
	
	@Test
	public void test0() {
		Auction auction = new Auction("Zero");
		List<Bidder> bidders = new ArrayList<Bidder>();
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNull(winner);
	}

	@Test
	public void testNull() {
		Auction auction = new Auction("Null");
		Bidder winner = auction.executeAuction(null);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNull(winner);
	}

}
