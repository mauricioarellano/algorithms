package com.hackerrank.challenges;

/**
 * 
 * @see https://www.hackerrank.com/challenges/grading
 *
 */
public class GradingStudents {
	static int[] solve(int[] grades){
        int[] result = new int[grades.length];
        
        for(int i=0; i<grades.length; i++){
        	int next = (grades[i]/5+1)*5;
        	
        	if(grades[i]>=38 && (next-grades[i])<3){
    			result[i] = next;
    		} else {
    			result[i] = grades[i];
    		}
    	}
		return result;
    }
}
