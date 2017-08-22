package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

public class SockMerchantTest {

	@Test
	public void testSockMerchant() {
		int[] array = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int expected = 3;
		int actual = SockMerchant.sockMerchant(9, array);
		assertEquals(expected, actual);
	}

}
