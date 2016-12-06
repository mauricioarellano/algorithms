package util;

import static org.junit.Assert.*;

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

}
