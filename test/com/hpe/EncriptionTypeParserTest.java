package com.hpe;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class EncriptionTypeParserTest {

	@Test
	public void testGetEncrType() {
		EncriptionTypeParser parser = new EncriptionTypeParser("[1, 0, 0, 0]");
		Assert.assertEquals(1, parser.getEncrType());
	}

}
