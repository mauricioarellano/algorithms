package com.onelogin.algorithms.linkedlist;

import java.util.Stack;

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
	public static boolean validateUsingStack(Node listOriginal) {
		Stack<Node> stack = new Stack<Node>();
		Node list = listOriginal;
		while(list != null) {
			Node item = new Node(list.val);
			stack.push(item );
			list = list.next;
		}
		
		
		return false;
	}
}
