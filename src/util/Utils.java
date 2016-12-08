package util;

import java.util.Arrays;
import java.util.Random;

public abstract class Utils {
	public static void exchange(int[] array, int posA, int posB){
		int tmp = array[posA];
		array[posA] = array[posB];
		array[posB]=tmp;
	}
	
	public static int[] generateArrayInt(int size, int min, int max){
		int[] array = new int[size];
		Random random = new Random();
		int bound = max - min + 1;
		
		for(int i=0; i<size; i++){
			array[i] = random.nextInt(bound) + min;
		}
		return array;
	}
	
	public static void printArray(int[] array){
		System.out.println(Arrays.toString(array));
	}
	
	public static void printArray(int[] array, int begin, int end){
		System.out.println(getArray(array, begin, end));
	}
	
	public static String getArray(int[] array, int begin, int end){
		return Arrays.toString(Arrays.copyOfRange(array, begin, end));
	}

	public static void swap(int[] array, int a, int b){
		exchange(array, a, b);
	} 

	public static boolean isSorted(int[] array) {
		int[] sorted = Arrays.copyOf(array, array.length);
		Arrays.sort(sorted);
		return false;
	}
	
	public static int[] reverse(int[] array){
		int[] result = new int[array.length];
		for(int i=0, j=array.length-1; i<array.length; i++,j--){
			result[i] = array[j];
		}
		return result;
	}

	public static int[] partialSortArray(int n) {
		return null;
	}

	public static int[] invertedArray(int n) {
		return null;
	}

	public static int[] createSortedArray(int elements) {
		return null;
	} 




}
