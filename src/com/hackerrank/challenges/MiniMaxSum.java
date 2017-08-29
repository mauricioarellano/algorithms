package com.hackerrank.challenges;
/**
 * 
 * @see https://www.hackerrank.com/challenges/mini-max-sum
 *
 */
public class MiniMaxSum {

	public static String solution(int[] array){
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i=0; i<array.length; i++){
			int sum = 0;
			for(int j=0; j<array.length; j++){
				if(j!=i){
					sum+=array[j];
				}
			}
			if(sum>max){
				max=sum;
			}
			if(sum<min){
				min=sum;
			}
		}
		
		return min + " " + max;
	}
}
