package com.hpe;

public class DeviceInfo {

	private String strKey;
	private String activation_description;
	
	public DeviceInfo(String strKey, String activation_description) {
		this.strKey = strKey;
		this.activation_description = activation_description;
	}
	
	public String getDeviceInfo() { 
		String strTemp1 = activation_description.substring(
					activation_description.indexOf(strKey) + strKey.length() + 2, 
					activation_description.length()
				);
		System.out.println(strTemp1);
		System.out.println(activation_description.indexOf(strKey) + strKey.length());
		System.out.println(activation_description.length());
		strTemp1=strTemp1.substring(
						0, 
						activation_description.substring(
								activation_description.indexOf(strKey) + strKey.length(), 
								activation_description.length())
						.indexOf(";") - 2
				);   
		return strTemp1.substring(0, (strTemp1.indexOf(" ") == -1? strTemp1.length() : strTemp1.indexOf(" ")));
	}
}
