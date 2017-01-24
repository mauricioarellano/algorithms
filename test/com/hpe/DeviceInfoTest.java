package com.hpe;

import org.junit.Assert;
import org.junit.Test;

public class DeviceInfoTest {
	
	static String activation_description="SNMPv2-MIB::sysDescr.0 = STRING: Ubee PacketCable 1.5 W-EMTA <<HW_REV: 3.10.1; VENDOR: Ubee; BOOTR: 9.1.1b; SW_REV: 6.36.1011; MODEL: DVW2110>>";
	
	@Test
	public void testGetVendor() {
		String strKey="VENDOR";
		DeviceInfo dev = new DeviceInfo(strKey, activation_description);
		String result = dev.getDeviceInfo();
		Assert.assertEquals("Ubee", result);
	}

	@Test
	public void testGetSW_REV() {
		String strKey="SW_REV";
		DeviceInfo dev = new DeviceInfo(strKey, activation_description);
		String result = dev.getDeviceInfo();
		Assert.assertEquals("6.36.1011", result);
	}

	@Test
	public void testGetMODEL() {
		String strKey="MODEL";
		DeviceInfo dev = new DeviceInfo(strKey, activation_description);
		String result = dev.getDeviceInfo();
		Assert.assertEquals("DVW2110", result);
	}

}
