package com.hackerrank.challenges;

import static org.junit.Assert.*;

import org.junit.Test;

public class DesignerPDFViewerTest {

	@Test
	public void testHighlight() {
		
		int[] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
		String word = "abc";
		int expected = 9;
		
		int actual = DesignerPDFViewer.highlight(h, word);
		assertEquals(expected, actual);
	}

	@Test
	public void testHighlight2() {
		
		int[] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
		String word = "zaba";
		int expected = 28;
		
		int actual = DesignerPDFViewer.highlight(h, word);
		assertEquals(expected, actual);
	}

}
