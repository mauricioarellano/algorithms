package com.onelogin;

import java.util.Stack;

/** You are given two non-empty linked lists representing two non-negative integers. The most significant 
digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as 
a linked list.
*
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
* Follow up:
* What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
*
* Example:
*
* Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 8 -> 0 -> 7
*/


/**
* Definition for singly-linked list.
*/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
	public int getVal() {
		return val;
	}
	public void setNext(ListNode next) {
		this.next = next;
		
	}
	public ListNode getNext() {
		return next;
	}
}

class Solution {
// 2N + 2M + (N * (N + 1) / 2 ) + (M * (M + 1) / 2 )
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int l1Size = countElements(l1);
    int l2Size = countElements(l2);
    ListNode result = null;
    
    if(l1Size>l2Size){
        result = addLists(l1, l2);
    } else{
        result = addLists(l2, l1);
    }
    return result;
}

static ListNode addLists(ListNode l1,ListNode l2){
    int l1Size = countElements(l1);
    int l2Size = countElements(l2);
    ListNode result = null;
    int remaining=0;
    int val = 0;
    for(int i=l2Size-1, j=l1Size-1; j>=0; i--, j--){
        if(i>=0){
            val = getNodeAt(l2, i).getVal() + getNodeAt(l1, j).getVal() + remaining;
        } else {
            val = getNodeAt(l1, j).getVal() + remaining;
        }
        remaining = val/10;
        ListNode node = new ListNode(val%10);
        if(result==null){
            result = node;
        } else {
            node.setNext(result);
            result=node;
        }
    }
    
    return result;
}

static int countElements(ListNode node){
    int count = 0;
    if(node.getNext()!=null){
        count+=countElements(node.getNext());
    }
    return count;
}

static ListNode getNodeAt(ListNode node, int pos){
    if(pos>0){
        return getNodeAt(node.getNext(), pos-1);
    }
    return node;
}

static ListNode addTwoLists(ListNode l1, ListNode l2){ // O(2N) ?
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    ListNode node1 = l1;
    ListNode node2 = l2;
    ListNode result = null;
    int remaining = 0;
    
    while(node1.next!=null || node2.next!=null){ // O(N) if N > M
        if(node1!=null){
            stack1.push(node1.val);
            node1 = node1.next;
        }
        
        if(node2!=null){
            stack2.push(node2.val);
            node2 = node2.next;
        }
    }
    
    while(!stack1.empty() || !stack2.empty()){ // O(N)
        int val = remaining;
        if(!stack1.empty()){
            val += stack1.pop();
        }
        if(!stack2.empty()){
            val += stack2.pop();
        }
        
        remaining = val/10;
        ListNode node = new ListNode(val%10);
        if(result==null){
            result = node;
        } else {
            node.setNext(result);
            result=node;
        }
    }
    return result;
}

}

public class Interview2 {

	public static void main(String[] args) {
		

	}

}
