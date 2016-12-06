package sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testSort() {
		int [] array = 	 {9,8,7,6,5,4,3,2,1,0, -1, -2, 0, 1, 9};
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);
		int [] sorted = null;
		
		System.out.println("Unsorted: \t" + Arrays.toString(array));
		sorted = MergeSort.sort(array);
		System.out.println("Sorted: \t" + Arrays.toString(sorted) );
		Assert.assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testUnsorted(){
		int [] array = 	 {9,8,7,6,5,4,3,2,1,0};
		int[] expected = {0,1,2,3,4,5,6,7,8,9};
		int [] sorted = null;
		
		System.out.println("Unsorted: \t" + Arrays.toString(array));
		sorted = MergeSort.sort(array);
		System.out.println("Sorted: \t" + Arrays.toString(sorted) );
		Assert.assertArrayEquals(expected, sorted);
	}

}
