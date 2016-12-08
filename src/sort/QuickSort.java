package sort;

import java.io.IOException;
import java.util.Scanner;

import util.Utils;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] sort(int[] array) {
		
		sort(array, 0, array.length-1);
		
		return array;
	}

	private static void sort(int[] array, int begin, int end) {
		int pivot = end;
		int i=begin;
		int j=end-1;
		
		//System.out.println("begin["+begin+"] end["+end+"] pivot["+pivot+"] Array: " + Utils.getArray(array, begin, end+1));
		//System.out.println("array["+i+"]='"+array[i]+"' array["+j+"]='"+array[j]+"' pivot["+pivot+"]='"+array[pivot]+"' array: " + Utils.getArray(array, begin, end));
		while(i<j){
			
			if(array[i]>=array[pivot] && array[pivot]>array[j]){
				Utils.swap(array, i, j);
				i++;
				j--;
			} else if(array[i]<array[pivot]){
				i++;
			} else if(array[j]>=array[pivot]){
				j--;
			}
			
			//System.out.println("array["+i+"]='"+array[i]+"' array["+j+"]='"+array[j]+"' pivot["+pivot+"]='"+array[pivot]+"' array: " + Utils.getArray(array, begin, end));
		}
		
		//System.out.println("begin["+begin+"] end["+end+"] pivot["+pivot+"] next["+(i)+"] Array: " + Utils.getArray(array, begin, end+1) + "");
		pivot = i;
		
		if(array[pivot]>array[end]){
			Utils.swap(array, pivot, end);
		}
		
		//System.out.println("Before branching array: " + Utils.getArray(array, begin, end+1));
		
		if(begin<pivot){
			sort(array, begin, pivot);
		}
		
		if((pivot+1)<=end){
			sort(array, pivot+1, end);
		}
	}

}
