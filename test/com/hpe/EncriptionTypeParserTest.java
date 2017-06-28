package com.hpe;

import org.junit.Test;

import junit.framework.Assert;

public class EncriptionTypeParserTest {

	@Test
	public void testGetEncrType() {
		EncriptionTypeParser parser = new EncriptionTypeParser("[1, 0, 0, 0]");
		Assert.assertEquals(1, parser.getEncrType());
	}
	
	@Test
	public void testGetPassphrase() {
		EncriptionTypeParser parser = new EncriptionTypeParser("['','pwd','']");
		Assert.assertEquals("pwd", parser.getPassphrase());
	}
	
	@Test
	public void testNoPassphrase() {
		EncriptionTypeParser parser = new EncriptionTypeParser("[]");
		Assert.assertEquals("", parser.getPassphrase());
	}

	@Test
	public void testGetPassphraseFilled() {
		EncriptionTypeParser parser = new EncriptionTypeParser("[colombia]");
		Assert.assertEquals("colombia", parser.getPassphrase());
	}

}
