package com.onelogin.algorithms.linkedlist;

/*
validate if a given linked list is a palindrome.
e.g.
  'a' -> 'a' -> 'b' -> 'a' -> 'a' -> null
  'a' -> 'a' -> 'b' -> 'b' -> 'a' -> 'a' -> null
*/

class Node {
  char val;
  Node next;
  public Node(char val){
    this.val = val;
  }
}

public class PalindromeValidator {
	public static boolean validateUsingStack(Node list) {
		return false;
	}
}
