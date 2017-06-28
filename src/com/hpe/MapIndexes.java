package com.hpe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapIndexes {

	private String descriptors;
	private String indexes;
	private String tag;
	public String oid_index;
	
	public MapIndexes(String descriptors, String indexes, String tag) {
		super();
		this.descriptors = descriptors;
		this.indexes = indexes;
		this.tag = tag;
	}
	
	public String getIndex(){
		System.out.println("descriptors: '" + descriptors + "', indexes: '" + indexes + "', tag: '" + tag + "'");
		String[] descriptorArray = getArray(descriptors);
		String[] indexArray = getArray(indexes);
		int index = getIndexOfTag(descriptorArray, tag.toUpperCase());
		if(index < 0){
			return null;
		}
		return indexArray[index];
	}
	
	public int getIndexOfTag(String[] array, String key) {
		for(int i=0; i<array.length; i++){
			if(array[i].toUpperCase().contains(key)){
				System.out.println("key: " + key + ", Tag: " + array[i] + ", pos: " + i);
				return i;
			}
		}
		return -1;
	}

	public String[] getArray(String string){
		String[] tokens = string.replace("[", "").replace("]", "").split(",");
		for (int i=0; i<tokens.length; i++) {
			tokens[i] = tokens[i].trim();
		}
		return tokens;
	}
	
	public String addToIndex(String valueToAdd){
		try{
			int result = Integer.parseInt(oid_index) + Integer.parseInt(valueToAdd);
			return String.valueOf(result);
		}
		catch(NumberFormatException e){
			return null;
		}
	}
}
