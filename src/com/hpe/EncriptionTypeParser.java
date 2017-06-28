package com.hpe;

public class EncriptionTypeParser {
	String activation_stdout= "[1, 0, 0, 0]";
	
	public EncriptionTypeParser(String activation_stdout) {
		this.activation_stdout = activation_stdout;
	}

	public int getEncrType(){
		if (activation_stdout.trim().isEmpty()){
			return -1;
		}
		
		String string = activation_stdout.substring(activation_stdout.indexOf("[")+1, activation_stdout.indexOf("]")!=-1?activation_stdout.indexOf("]"):activation_stdout.length());
		String[] tokens = string.split(",");
		int[] values = new int[tokens.length];
		for (int i=0; i<tokens.length; i++) {
			values[i] = Integer.parseInt(tokens[i].trim());
		}
		
		for (int i : values) {
			if( i>0){
				return i;
			}
		}
		return 0;
	}
	
	public String getPassphrase(){
		if (activation_stdout.trim().isEmpty()){
			return "";
		}
		
		String string = activation_stdout.substring(activation_stdout.indexOf("[")+1, activation_stdout.indexOf("]")!=-1?activation_stdout.indexOf("]"):activation_stdout.length());
		String[] tokens = string.split(",");
		
		for (String str : tokens) {
			str = str.replaceAll("'", "").trim();
			if( !str.isEmpty()){
				return str;
			}
		}
		
		return "";
	} 
}
