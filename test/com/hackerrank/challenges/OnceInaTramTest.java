package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class OnceInaTramTest {

	@Test
	public void testOnceInATram() {
		int x = 555555;
		String expected = "555564";
		String actual = OnceInaTram.onceInATram(x);
		Assert.assertEquals(expected, actual);
	}

}
