package com.onelogin.algorithms.linkedlist;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromeValidatorTest {

	@Test
	public void testValidateUsingStack() {
		Node n1 = new Node('a') ;
		Node n2 = new Node('a');
		Node n3 = new Node('b');
		Node n4 = new Node('b');
		Node n5 = new Node('a');
		Node n6 = new Node('a');
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		assertTrue(PalindromeValidator.validateUsingStack(n1));
	}

}
