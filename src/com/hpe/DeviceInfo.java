package com.hpe;

public class DeviceInfo {

	private String strKey;
	private String activation_description;
	
	public DeviceInfo(String strKey, String activation_description) {
		this.strKey = strKey;
		this.activation_description = activation_description;
	}
	
	public String getDeviceInfo() { 
		String result = activation_description.substring(activation_description.indexOf(strKey) + strKey.length() + 2,activation_description.length());
		int finalPos = result.indexOf(";")>0?result.indexOf(";"):result.indexOf(">")>0?result.indexOf(">"):result.length();
		result = result.substring(0, finalPos);
		return result;
	}

	public String getDeviceInfoCM() {
		if(strKey.startsWith(".")){
			strKey = strKey.substring(1, strKey.length());
		}
		strKey = strKey.concat(" ");
		return getDeviceInfo();
	}
}
