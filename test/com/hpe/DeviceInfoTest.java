package com.hpe;

import org.junit.Assert;
import org.junit.Test;

public class DeviceInfoTest {
	
	static String activation_description = "SNMPv2-MIB::sysDescr.0 = STRING: Ubee PacketCable 1.5 W-EMTA <<HW_REV: 3.10.1; VENDOR: Ubee; BOOTR: 9.1.1b; SW_REV: 6.36.1011; MODEL: DVW2110>>";
	//static String activation_description = "GLOBAL.executeSnmp(DO_AND_CHECK, 10.255.255.137, 161, GET, .1.3.6.1.2.1.1.1.0, int:1, hpe2016, 2, 3, 5000, 3, 1) : 1.3.6.1.2.1.1.1.0 = Thomson CableHome PacketCable Gateway E-MTA <<HW_REV: 1.0; VENDOR: Thomson; BOOTR: 2.1.7i; SW_REV: STC0.01.16; MODEL: DWG849>>";
	
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

	@Test
	public void testGetMAC_CM() {
		String strKey="1.3.6.1.2.1.2.2.1.6.2";
		String string = "GLOBAL.executeSnmp(DO_AND_CHECK, 10.255.255.137, 161, GET, 1.3.6.1.2.1.2.2.1.6.2, int:1, hpe2016, 2, 3, 5000, 3, 1) : 1.3.6.1.2.1.2.2.1.6.2 = 80:c6:ab:c9:46:97";
		DeviceInfo dev = new DeviceInfo(strKey, string);
		String result = dev.getDeviceInfoCM();
		Assert.assertEquals("80:c6:ab:c9:46:97", result);
	}

	@Test
	public void testGetMAC_MTA() {
		String strKey=".1.3.6.1.2.1.2.2.1.6.16";
		String string = "GLOBAL.executeSnmp(DO_AND_CHECK, 10.255.255.137, 161, GET, .1.3.6.1.2.1.2.2.1.6.16, int:1, hpe2016, 2, 3, 5000, 3, 1) : 1.3.6.1.2.1.2.2.1.6.16 = 80:c6:ab:c9:46:98";
		DeviceInfo dev = new DeviceInfo(strKey, string);
		String result = dev.getDeviceInfoCM();
		Assert.assertEquals("80:c6:ab:c9:46:98", result);
	}

	@Test
	public void testGetNUM_PORTS() {
		String strKey=".1.3.6.1.4.1.4491.2.2.1.1.1.6";
		String string = "GLOBAL.executeSnmp(DO_AND_CHECK, 10.255.255.137, 161, GET, .1.3.6.1.4.1.4491.2.2.1.1.1.6, int:1, hpe2016, 2, 3, 5000, 3, 1) : 1.3.6.1.4.1.4491.2.2.1.1.1.6 = noSuchObject";
		DeviceInfo dev = new DeviceInfo(strKey, string);
		String result = dev.getDeviceInfoCM();
		Assert.assertEquals("noSuchObject", result);
	}

}
