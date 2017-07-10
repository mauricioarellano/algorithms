package com.luxoft;

import java.util.HashSet;
import java.util.Set;

/*
Write a method which receives an array of ints, and prints only those that are repeated.
Input: [1,3,5,1,7,9,1,5]
Output:
1
5
*/
public class PrintRepeated {
	public static void printRepeated(int[] array){
	    Set<Integer> uniques = new HashSet<Integer>();
	    Set<Integer> repeated = new HashSet<Integer>();
	    for(int i=0; i<array.length; i++){
	      if(!uniques.add(array[i])){
	        repeated.add(array[i]);
	      }
	    }
	    
	    for(Integer e: repeated){
	    	System.out.println(e);
	    }
	  }
}
