package com.luxoft;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageRotationTest {

	@Test
	public void testRotate() {
		int[][] matrix = {{1, 2, 3, 4}, {12, 13, 14, 5 }, {11, 16, 15, 6}, {10, 9, 8, 7}};
		ImageRotation.print(matrix);
	    System.out.println("");
	    ImageRotation.print (ImageRotation.rotate(matrix));
	}

}
