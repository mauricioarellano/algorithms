package sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import util.Utils;

public class QuickSortTest {

	@Test
	public void test(){
		int [] array = {1, 0, -2, -1, 0, 1, 2, 3};
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);
		int [] sorted = null;
		long start = System.currentTimeMillis();
		
		sorted = QuickSort.sort(array);
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Unsorted: \t" + Arrays.toString(array));
		System.out.println("Sorted: \t" + Arrays.toString(sorted) + " in " + time + "ms");
		System.out.println("Expected: \t" + Arrays.toString(expected) );
		Assert.assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testSort() {
		int [] array = 	 {9,8,7,6,5,4,3,2,1,0, -1, -2, 0, 1, 9};
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);
		int [] sorted = null;
		long start = System.currentTimeMillis();
		
		sorted = QuickSort.sort(array);
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Unsorted: \t" + Arrays.toString(array));
		System.out.println("Sorted: \t" + Arrays.toString(sorted)  + " in " + time + "ms");
		System.out.println("Expected: \t" + Arrays.toString(expected) );
		Assert.assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testUnsorted(){
		int size = 10_000; 
		int [] array = 	 Utils.generateArrayInt(size, 0, 100); //{9,8,7,6,5,4,3,2,1,0};
		Arrays.sort(array);
		int[] expected = Arrays.copyOf(array, array.length); //{0,1,2,3,4,5,6,7,8,9};
		array = Utils.reverse(array);
		int [] sorted = null;
		
		long start = System.currentTimeMillis();
		sorted = QuickSort.sort(array);
		long time = System.currentTimeMillis() - start;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted)  + " in " + time + "ms");
		System.out.println("UnSorted "+size+" elements in "+time+"ms");
		Assert.assertArrayEquals(expected, sorted);
	}
	
	@Test
	public void testSorted(){
		int size = 10_000; 
		int [] array = 	 Utils.generateArrayInt(size, 0, 100); //{9,8,7,6,5,4,3,2,1,0, -1, -2, 0, 1, 9};
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(array);
		Arrays.sort(expected);
		int [] sorted = null;
		long start = System.currentTimeMillis();
		
		sorted = QuickSort.sort(array);
		long time = System.currentTimeMillis() - start;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted)  + " in " + time + "ms");
		System.out.println("Sorted "+size+" elements in "+time+"ms");
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
		sorted = QuickSort.sort(array);
		long end = System.currentTimeMillis() - init;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted) + "in "+end+"ms");
		
		System.out.println("Sorted "+size+" elements in "+end+"ms");
		
		Assert.assertArrayEquals(expected, sorted);
	}
	
	//@Test
	public void testSortHundredMillion() {
		int size = 100_000_000;
		int [] array = Utils.generateArrayInt(size, 0, 1000);
		int [] expected = Arrays.copyOf(array, array.length);
		int [] sorted = null;
		Arrays.sort(expected);
		
		long init = System.currentTimeMillis(); 
		sorted = QuickSort.sort(array);
		long end = System.currentTimeMillis() - init;
		
		//System.out.println("Unsorted: \t" + Arrays.toString(array));
		//System.out.println("Sorted: \t" + Arrays.toString(sorted) + "in "+end+"ms");
		
		System.out.println("Sorted "+size+" elements in "+end+"ms");
		
		Assert.assertArrayEquals(expected, sorted);
	}

}
