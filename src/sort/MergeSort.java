package sort;

import java.util.Arrays;

import sun.security.util.Length;
import util.Utils;

public class MergeSort {

	public static void main(String[] args) {
		int [] array = {9,8,7,6,5,4,3,2,1,0};
		System.out.println("Unsorted: " + Arrays.toString(array));
		int [] sorted = sort(array, 0, array.length-1);
		System.out.println("Sorted: " + Arrays.toString(sorted));
	}
	
	public static int[] sort(int[] array) {
		return sort(array, 0, array.length-1);
	}

	private static int[] sort(int[] array, int begin, int end) {
		// divide in half
		int half = (end+begin) / 2;
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, begin, end+1)) + " begin["+begin+"] half["+half+"] end["+end+"]" );
		
		
		if (begin==end){
			return array;
		} else if( end-begin == 1) {
			System.out.println("switching " + array[begin] +"<->"+ array[end]);
			Utils.exchange(array, begin, end);
			return array;
		}
		
		//sort left half
		System.out.println("sorting left ["+begin+"]-["+half+"]");
		sort(array, begin, half);
		
		// sort right half
		System.out.println("sorting right ["+(half+1)+"]-["+end+"]");
		sort(array, half+1, end);
		
		//merge both halfs
		//System.out.println("merging " + Arrays.toString(Arrays.copyOfRange(array, begin, half+1)) + " - " + Arrays.toString(Arrays.copyOfRange(array, half+1, end+1)));
		//merge(array, begin, half, half+1, end);
		merge(array, begin, end);
		return array;
	}

	private static void merge(int[] array, int begin, int end) {
		int index = begin;
		int half = (begin+end)/2;
		int leftIndex=0;
		int rightIndex = 0;
		int[] left = Arrays.copyOfRange(array, begin, half+1);
		int[] right = Arrays.copyOfRange(array, half+1, end+1);
		System.out.println("Partially sorted " + Arrays.toString(Arrays.copyOfRange(array, begin, end+1)) );
		System.out.println("Merging " + Arrays.toString(left) + " - " + Arrays.toString(right));
		
		while(index <= end ) {
			System.out.println("index["+index+"] left["+leftIndex+"], right["+rightIndex+"]");
			if(rightIndex==right.length || (leftIndex<left.length && left[leftIndex] <= right[rightIndex])){
				array[index++] = left[leftIndex++];
			} else if(rightIndex<right.length){
				array[index++]=right[rightIndex++];
			}
		}
		System.out.println("merged: " + Arrays.toString(Arrays.copyOfRange(array, begin, end+1)));
	}

	private static void merge(int[] array, int begin1, int end1, int begin2, int end2) {
		
		for(int i=begin1; i<=end1; i++){
			for(int j=begin2; j<=end2; j++){
				if(array[i] > array[j]){
					Utils.exchange(array, i, j);
				}
			}
		}
		// sort right half
		sort(array, begin2, end2);

		System.out.println("merged: " + Arrays.toString(Arrays.copyOfRange(array, begin1, end2+1)));
	}

}
