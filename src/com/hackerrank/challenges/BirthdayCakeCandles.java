package com.hackerrank.challenges;

/**
 * 
 * @see https://www.hackerrank.com/challenges/birthday-cake-candles
 *
 */
public class BirthdayCakeCandles {
	public static int birthdayCakeCandles(int n, int[] arrray){
		int result = 0;
		int max = 0;
		for (int i : arrray) {
			//System.out.println("i: " + i + ", max: " + max);
			if(i>max){
				max = i;
				result = 1;
			} else if(i==max){
				result++;
			}
		}
		return result;
	}
}
