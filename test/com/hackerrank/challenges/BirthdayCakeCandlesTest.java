package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

public class BirthdayCakeCandlesTest {

	@Test
	public void test() {
		int n = 4;
        int[] ar = {3, 2, 1, 3};
        int expected = 2;
        int actual = BirthdayCakeCandles.birthdayCakeCandles(n, ar);
		assertEquals(expected, actual);
	}

}
