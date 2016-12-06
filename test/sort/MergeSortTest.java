package sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import util.Utils;

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
		System.out.println("Expected: \t" + Arrays.toString(expected) );
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
	
	@Test
	public void testSortMillion() {
		int size = 1_000_000;
		int [] array = Utils.generateArrayInt(size, 0, 1000);
		int [] expected = Arrays.copyOf(array, array.length);
		int [] sorted = null;
		Arrays.sort(expected);
		
		long init = System.currentTimeMillis(); 
		sorted = MergeSort.sort(array);
		long end = System.currentTimeMillis() - init;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted) + "in "+end+"ms");
		
		System.out.println("Sorted "+size+" elements in "+end+"ms");
		
		Assert.assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testSortHundredMillion() {
		int size = 100_000_000;
		int [] array = Utils.generateArrayInt(size, 0, 1000);
		int [] expected = Arrays.copyOf(array, array.length);
		int [] sorted = null;
		Arrays.sort(expected);
		
		long init = System.currentTimeMillis(); 
		sorted = MergeSort.sort(array);
		long end = System.currentTimeMillis() - init;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted) + "in "+end+"ms");
		
		System.out.println("Sorted "+size+" elements in "+end+"ms");
		
		Assert.assertArrayEquals(expected, sorted);
	}

}
