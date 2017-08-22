package com.hackerrank.challenges;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @see https://www.hackerrank.com/challenges/sock-merchant
 * 
 * Sample Input
 * 9
 * 10 20 20 10 10 30 50 10 20
 * 
 * Sample Output
 * 3
 *
 */
public class SockMerchant {
	static int sockMerchant(int n, int[] ar) {
		return sockMerchant(ar);
	}


	private static int sockMerchant(int[] ar) {
		int count = 0;
		Set<Integer> socks = new TreeSet<Integer>();
		for (int i : ar) {
			if(!socks.add(i)){
				socks.remove(i);
				count++;
			}
		}
		return count;
	}
}
