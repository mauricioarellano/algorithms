package com.hpe;

public class DeviceInfo {

	private String strKey;
	private String activation_description;
	private String activation_stdout;
	
	public DeviceInfo(String strKey, String activation_description) {
		this.strKey = strKey;
		this.activation_description = activation_description;
	}
	
	public void setActivation_stdout(String activation_stdout) {
		this.activation_stdout = activation_stdout;
	}

	public String getDeviceInfo() { 
		String result = activation_description.substring(activation_description.lastIndexOf(strKey) + strKey.length() + 2,activation_description.length());
		int finalPos = result.indexOf(";")>0?result.indexOf(";"):result.indexOf(">")>0?result.indexOf(">"):result.length();
		result = result.substring(0, finalPos);
		result = result.substring(0, result.indexOf(" ")>0?result.indexOf(" "):result.length());
		return result;
	}

	public String getDeviceInfoCM() {
		if(strKey.startsWith(".")){
			strKey = strKey.substring(1, strKey.length());
		}
		strKey = strKey.concat(" ");
		return getDeviceInfo();
	}
	
	public int getDeviceInfoPorts() {
		if(strKey.startsWith(".")){
			strKey = strKey.substring(1, strKey.length());
		}
		strKey = strKey.concat(" ");
		Integer result;
		
		try{
			result = Integer.parseInt(getDeviceInfoCM());
		} catch(Exception e) {
			result = -1;
		}
		
		return result;
	}

	public String cleanBrackets() {
		String string = activation_stdout.replace("[", "").replace("]", "");
		return string;
	}
	
	public String activationStdoutTrim(){
		return activation_stdout.trim();
	}
	
	public int parseInt(){
		String string = activation_stdout.trim();
		try{
			return Integer.parseInt(string);
		} catch (NumberFormatException e){
			return -1;
		}
	}
}
