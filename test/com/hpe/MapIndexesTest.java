package com.hpe;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MapIndexesTest {

	//String descriptors = "[eRouter Embedded Interface, RF MAC Interface, RF Downstream Interface, RF Upstream Interface, External Switch Port 1, External Switch Port 2, External Switch Port 3, External Switch Port 4, Wireless Interface, PacketCable Embedded Interface, RF Downstream Interface 1, RF Downstream Interface 2, RF Downstream Interface 3, RF Downstream Interface 4, RF Downstream Interface 5, RF Downstream Interface 6, RF Downstream Interface 7, RF Upstream Interface 1, RF Upstream Interface 2, RF Upstream Interface 3, Logical Lan Interface 1, Logical Lan Interface 2, Logical Lan Interface 3, Logical Lan Interface 4, Wan Side Interface 1: For CM, Wan Side Interface 2: For eRouter, Wan Side Interface 3: For MTA, Wi-Fi 2.4GHz Radio interface, Wi-Fi 2.4GHz SSID sub-interface 1, Wi-Fi 2.4GHz SSID sub-interface 2, Wi-Fi 2.4GHz SSID sub-interface 3, Wi-Fi 2.4GHz SSID sub-interface 4]";
	//String indexes = "[1, 2, 3, 4, 6, 7, 8, 9, 12, 16, 48, 49, 50, 51, 52, 53, 54, 80, 81, 82, 200, 201, 202, 203, 300, 301, 302, 10000, 10001, 10002, 10003, 10004]";
	
	String descriptors = "[eRouter Embedded Interface, RF MAC Interface, RF Downstream Interface 1, RF Upstream Interface 1, Software Loopback, Ethernet CPE Interface, Ethernet CPE Interface, PacketCable Embedded Interface, RF Downstream Interface 2, RF Downstream Interface 3, RF Downstream Interface 4, RF Downstream Interface 5, RF Downstream Interface 6, RF Downstream Interface 7, RF Downstream Interface 8, RF Upstream Interface 2, RF Upstream Interface 3, RF Upstream Interface 4, Radio Interface(0), WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256]";
	String indexes = "[1, 2, 3, 4, 5, 6, 7, 16, 48, 49, 50, 51, 52, 53, 54, 80, 81, 82, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008]";
	
	@Test
	public void testRadio() {
		String tag = "Radio interface";
		MapIndexes mapper = new MapIndexes(descriptors, indexes, tag);
		String index = mapper.getIndex();
		Assert.assertEquals("10000", index);
	}

	@Test
	public void testSSID() {
		String tag = "SSID";
		MapIndexes mapper = new MapIndexes(descriptors, indexes, tag);
		String index = mapper.getIndex();
		Assert.assertEquals("10001", index);
	}
	
	@Test
	public void testWIFIUbeeDVW2110(){
		String tag = "WIFI";
		indexes= "'[1, 2, 3, 4, 5, 6, 16, 32, 33, 34, 35]";
		descriptors = "[eRouter Embedded Interface, Broadcom BCM3379 r.A0 CM CATV-MAC IF, Broadcom BCM3379 r.A0 CM CATV-DS IF, Broadcom BCM3379 r.A0 CM CATV-US IF, Software Loopback, Broadcom BCM3379 Rev. a0, Ethernet NI, PacketCable Embedded Interface, WiFi CPE Interface BCM17171 P211, WiFi CPE Interface BCM17171 P211, WiFi CPE Interface BCM17171 P211, WiFi CPE Interface BCM17171 P211]";
		MapIndexes mapper = new MapIndexes(descriptors, indexes, tag);
		String index = mapper.getIndex();
		Assert.assertEquals("32", index);
	}
	
	@Test
	public void testRadioUbeeDVW32H(){
		String tag = "RADIO";
		String indexes= "[1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 48, 49, 50, 51, 52, 53, 54, 80, 81, 82, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008]";
		String descriptors = "[eRouter Embedded Interface, RF MAC Interface, RF Downstream Interface 1, RF Upstream Interface 1, Software Loopback, Ethernet CPE Interface, Ethernet CPE Interface, Ethernet CPE Interface, Ethernet CPE Interface, PacketCable Embedded Interface, RF Downstream Interface 2, RF Downstream Interface 3, RF Downstream Interface 4, RF Downstream Interface 5, RF Downstream Interface 6, RF Downstream Interface 7, RF Downstream Interface 8, RF Upstream Interface 2, RF Upstream Interface 3, RF Upstream Interface 4, Radio Interface(0), WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256]";
		MapIndexes mapper = new MapIndexes(descriptors, indexes, tag);
		String index = mapper.getIndex();
		Assert.assertEquals("10000", index);
	}
	
	@Test
	public void testWIFIUbeeDVW32H(){
		String tag = "WIFI";
		String indexes= "[1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 48, 49, 50, 51, 52, 53, 54, 80, 81, 82, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008]";
		String descriptors = "[eRouter Embedded Interface, RF MAC Interface, RF Downstream Interface 1, RF Upstream Interface 1, Software Loopback, Ethernet CPE Interface, Ethernet CPE Interface, Ethernet CPE Interface, Ethernet CPE Interface, PacketCable Embedded Interface, RF Downstream Interface 2, RF Downstream Interface 3, RF Downstream Interface 4, RF Downstream Interface 5, RF Downstream Interface 6, RF Downstream Interface 7, RF Downstream Interface 8, RF Upstream Interface 2, RF Upstream Interface 3, RF Upstream Interface 4, Radio Interface(0), WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256, WiFi CPE Interface BCM43217 P256]";
		MapIndexes mapper = new MapIndexes(descriptors, indexes, tag);
		String index = mapper.getIndex();
		Assert.assertEquals("10001", index);
	}

	@Test
	public void testSplitDescriptors() {
		MapIndexes mapper = new MapIndexes(descriptors, indexes, null);
		mapper.getArray(descriptors);
	}
	
	@Test
	public void testSplitIndexes() {
		MapIndexes mapper = new MapIndexes(descriptors, indexes, null);
		mapper.getArray(indexes);
	}
	
	@Test
	public void testAddToIndex1() {
		MapIndexes mapper = new MapIndexes(descriptors, indexes, null);
		mapper.oid_index="10000";
		String value = "1";
		String result = mapper.addToIndex(value);
		Assert.assertEquals("10001", result);
	}
}
