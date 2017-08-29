package com.hackerrank.challenges;

import java.util.Arrays;

/**
 * 
 * @see https://www.hackerrank.com/challenges/designer-pdf-viewer
 *
 */
public class DesignerPDFViewer {

	public static int highlight(int[] h, String word){
		int result = 0;
		int a = 'a';
		int max = 0;
		//System.out.println("a: " + a);
		//System.out.println("value: " + (word.charAt(0)-a));
		//System.out.println("word: " + Arrays.toString(word.toCharArray()));
		for (char c: word.toCharArray()) {
			int index = c-a; 
			//System.out.println(c + " value: " + (c-a));
			if(h[index]>max){
				max=h[index];
			}
		}
		result = max * word.length();
		//System.out.println("max: "+max+", word.lenght(): "+word.length()+",result: " + result);
		return result;
	}
}
