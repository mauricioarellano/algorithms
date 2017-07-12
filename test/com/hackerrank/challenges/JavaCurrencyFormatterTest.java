package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class JavaCurrencyFormatterTest {
	double payment = 12324.134;
	
	@Test
	public void testUs() {
		String country = "US";
		String expected = "$12,324.13";
		String actual = JavaCurrencyFormatter.formatPayment(payment, country);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIndia() {
		String country = "India";
		String expected = "Rs.12,324.13";
		String actual = JavaCurrencyFormatter.formatPayment(payment, country);
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testChina() {
		String country = "China";
		String expected = "￥12,324.13";
		String actual = JavaCurrencyFormatter.formatPayment(payment, country);
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testFrance() {
		String country = "France";
		String expected = "12 324,13 €";
		String actual = JavaCurrencyFormatter.formatPayment(payment, country);
		Assert.assertEquals(expected, actual);
	}
	
}
