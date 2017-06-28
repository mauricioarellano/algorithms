package com.hpe;

public class PrimitiveParser {

	char ping_delay1;
	
	public int parseInt(){
		try{
			return Integer.parseInt(String.valueOf(ping_delay1));
		} catch (NumberFormatException e){
			return -1;
		}
	}
}
