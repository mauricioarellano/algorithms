package util;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

	@Test
	public void testExchange() {
		int [] array =    {9,8,7,6,5,4,3,2,1,0};
		int [] expected = {0,8,7,6,5,4,3,2,1,9};
		Utils.exchange(array, 0, array.length-1);
		Assert.assertArrayEquals(expected, array);
	}
	
	@Test
	public void testGenerateArrayInt() {
		int size = 10;
		int[] array = Utils.generateArrayInt(size, -2, 10);
		Utils.printArray(array);
		Assert.assertNotNull(array);
		Assert.assertEquals(size, array.length);
	}
	
	@Test
	public void testPrintArray() {
		int [] array =    {0,1,2,3,4,5,6,7,8,9};
		Utils.printArray(array);
		Utils.printArray(array, 0, 3);
		
	}
	
	@Test
	public void testReverse() {
		int [] array =   {0,1,2,3,4,5,6,7,8,9};
		int[] expected = {9,8,7,6,5,4,3,2,1,0};
		int [] reverse = Utils.reverse(array);
		Assert.assertNotNull(reverse);
		Assert.assertEquals(array.length, reverse.length);
		
	}

}
