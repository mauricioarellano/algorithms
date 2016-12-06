package util;

public abstract class Utils {
	public static void exchange(int[] array, int posA, int posB){
		int tmp = array[posA];
		array[posA] = array[posB];
		array[posB]=tmp;
	}
}
