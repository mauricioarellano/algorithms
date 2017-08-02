package com.hackerrank.challenges;
/**
 * 
 * @see https://www.hackerrank.com/contests/w34/challenges/once-in-a-tram/
 *
 */
public class OnceInaTram {
	static String onceInATram(int x) {
        // Complete this function
        return String.valueOf(nextLucky(x));
    }
    
    static int nextLucky(int x){
        int next = x;
        while(true){
            next++;
            System.out.println(next + "is lucky? " + isLucky(next));
            if(isLucky(next))
                return next;
        }
    }
    
    static boolean isLucky(int x){
        int left = getSum(x/1000);
        int right = getSum(x%1000);
        return left==right;
    }
    
    static int getSum(int x){
    	System.out.println("x = " + x);
        int unit = x%10;
        int dec = (x%100) / 10;
        int cent = x/100;
        System.out.println(cent + " + " + dec + " + " + unit + " = " + (cent+dec+unit));
        return cent+dec+unit;
            
    }
}
