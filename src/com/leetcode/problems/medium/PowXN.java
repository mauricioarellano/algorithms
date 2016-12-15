package com.leetcode.problems.medium;

public class PowXN {
	public static double myPow(double x, int n) {
		int halfPow = n/2;
		
		double result = myPowIterative(x, halfPow);
		result *= result;
		
//		if(n%2==1){
//			result *= x;
//		} else if(n%2==-1) {
//			result /= x;
//		}
//		
		result *= myPowIterative(x, (n%2));
		
		return result;
	}
	
	private static double myPowIterative(double x, int n) {
		double result = 1;

		if(n>0){
			for(int i=0; i<n; i++){
				result *= x;
			}
		} else if(n<0){
			for(int i=n; i<0; i++){
				result /= x;
			}
		}
		
		return result;
    }
}
