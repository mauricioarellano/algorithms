package search;

public class BinarySearch {

	public static int search(int[] array, int value){
		int index = -1;
		int begin =0;
		int end = array.length-1;
		int half = (end-begin)/2;
		
		if(array[half]==value){
			return half;
		} else if(array[half]<value){
			
		}
		
		return index;
	}
}
