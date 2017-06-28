package com.hpe;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MacAddressFormaterTest {

	@Test
	public void testFormatMacAddress() {
		String macUnformatted = "906EBB5A9B9A";
		String macExpected = "90:6e:bb:5a:9b:9a";
		MacAddressFormater formater = new MacAddressFormater(macUnformatted );
		Assert.assertEquals(macExpected, formater.formatMacAddress());
	}

	@Test
	public void testValidateMacAddressCorrect(){
		String macExpected = "90:6e:bb:5a:9b:9a";
		MacAddressFormater formater = new MacAddressFormater(macExpected);
		Assert.assertTrue(formater.validateMacAddress());
		
	}
	
	@Test
	public void testValidateMacAddressIncorrect(){
		String macExpected = "90:6e:bb:5a9b:9a";
		MacAddressFormater formater = new MacAddressFormater(macExpected);
		Assert.assertFalse(formater.validateMacAddress());
		
	}
}
