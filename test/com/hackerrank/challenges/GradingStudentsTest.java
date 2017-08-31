package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

public class GradingStudentsTest {

	@Test
	public void test() {
		int[] grades = {73, 67, 38, 33};
		int[] expected = {75, 67, 40, 33};
		int[] result = GradingStudents.solve(grades);
        assertArrayEquals(expected, result);
	}

}
