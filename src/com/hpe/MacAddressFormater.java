package com.hpe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacAddressFormater {
	private static final String MAC_PATTERN = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

	private String mac_address="";
	
	public MacAddressFormater(String mac_address) {
		super();
		this.mac_address = mac_address;
	}

	public String formatMacAddress(){
		if(validateMacAddress()){
			return mac_address;
		}
		
		String mac = mac_address.toLowerCase();
		StringBuilder macAddress = new StringBuilder();
		
		for(int i=0; i<mac.length(); i++){
			if(i>0 && i%2==0){
				macAddress.append(':');
			}
			macAddress.append(mac.charAt(i));
		}
		
		return macAddress.toString();
	}
	
	public boolean validateMacAddress(){
		Pattern pattern = Pattern.compile(MAC_PATTERN);
	    Matcher matcher = pattern.matcher(mac_address);
	    return matcher.matches();
	}
}
