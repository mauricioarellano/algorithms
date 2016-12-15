package com.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class PowXNTest {

	@Test
	public void testMyPow() {
		double x = 8.88023;
		int n = 3;
		double expected = Math.pow(x, n);;
		
		double result = PowXN.myPow(x, n);
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testBigPow() {
		double x = 0.00001;
		int n = 2_147_483_647;
		double expected = Math.pow(x, n);;
		
		double result = PowXN.myPow(x, n);
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testNegativePow() {
		double x = 34.00515;
		int n = -3;
		double expected = Math.pow(x, n);;
		
		double result = PowXN.myPow(x, n);
		Assert.assertEquals(expected, result);
	}
	
	
	@Test
	public void test10pow3() {
		double x = 10;
		int n = 3;
		double expected = 1000;
		
		double result = PowXN.myPow(x, n);
		Assert.assertEquals(expected, result);
		//fail("Not yet implemented");
	}

}
