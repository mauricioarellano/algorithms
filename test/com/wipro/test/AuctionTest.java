package com.wipro.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wipro.test.entities.Bidder;
import com.wipro.test.entities.Offer;

public class AuctionTest {

	@Test
	public void testNull() {
		Auctioneer auction = new Auction("Null");
		Bidder winner = auction.executeAuction(null);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNull(winner);
	}

	@Test
	public void test0() {
		Auctioneer auction = new Auction("Zero");
		List<Bidder> bidders = new ArrayList<Bidder>();
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNull(winner);
	}

	@Test
	public void testAuctionOne() {
		Auctioneer auction = new Auction("Record player");
		Bidder linda = new Bidder("Linda", new Offer(170, 240, 3));
		Bidder dave =  new Bidder("Dave",  new Offer(160, 243, 7));
		Bidder eric =  new Bidder("Eric",  new Offer(190, 240, 4));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNotNull(winner);
		assertEquals(linda, winner);
	}

	@Test
	public void testAuctionTwo() {
		Auctioneer auction = new Auction("Snow shoes");
		Bidder linda = new Bidder("Linda", new Offer(30, 70, 4));
		Bidder dave =  new Bidder("Dave",  new Offer(30, 70, 3));
		Bidder eric =  new Bidder("Eric",  new Offer(40, 90, 2));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNotNull(winner);
		assertEquals(eric, winner);
	}

	@Test
	public void testAuctionThree() {
		Auctioneer auction = new Auction("Piano");
		Bidder linda = new Bidder("Linda", new Offer(20_000, 65_000,  2_000));
		Bidder dave =  new Bidder("Dave",  new Offer(10_000, 70_000, 15_000));
		Bidder eric =  new Bidder("Eric",  new Offer(22_000, 70_000,  8_000));
		
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNotNull(winner);
		assertEquals(dave, winner);
	}
	
	@Test
	public void testAuctionOneInitialValue() {
		Auctioneer auction = new Auction("Record player starting with 200");
		int initialBid = 200;
		
		Bidder linda = new Bidder("Linda", new Offer(170, 240, 3));
		Bidder dave =  new Bidder("Dave",  new Offer(160, 243, 7));
		Bidder eric =  new Bidder("Eric",  new Offer(190, 240, 4));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		
		Bidder winner = auction.executeAuction(bidders, initialBid);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNotNull(winner);
		assertEquals(linda, winner);
	}
	
	@Test
	public void testAuctionOneNoWinner() {
		Auctioneer auction = new Auction("Record player starting with 240");
		Bidder linda = new Bidder("Linda", new Offer(170, 240, 3));
		Bidder dave =  new Bidder("Dave",  new Offer(160, 243, 7));
		Bidder eric =  new Bidder("Eric",  new Offer(190, 240, 4));
		List<Bidder> bidders = new ArrayList<Bidder>();
		
		bidders.add(linda);
		bidders.add(dave);
		bidders.add(eric);
		int initialBid = 240;
		Bidder winner = auction.executeAuction(bidders, initialBid);
		System.out.println("== " + auction + " winner is: " + winner + " ==\n");
		assertNull(winner);
	}
	
}
