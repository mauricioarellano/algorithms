package com.hakerrank.kueski;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.hackerrank.kueski.LastSubstring;

public class LastSubstringTest {

	@Test
	public void ab() {
		String s = "ab";
		String expected = "b";
		String actual = LastSubstring.compute(s);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void ba() {
		String s = "ba";
		String expected = "ba";
		String actual = LastSubstring.compute(s);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void aaa() {
		String s = "aaa";
		String expected = "aaa";
		String actual = LastSubstring.compute(s);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void banana() {
		String s = "banana";
		String expected = "nana";
		String actual = LastSubstring.compute(s);
		Assert.assertEquals(expected, actual);
	}
}
