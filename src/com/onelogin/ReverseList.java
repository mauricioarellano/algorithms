package com.onelogin;

/*Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing links between nodes.

Examples:

Input : Head of following linked list  
       1->2->3->4->NULL
Output : Linked list should be changed to,
       4->3->2->1->NULL

Input : Head of following linked list  
       1->2->3->4->5->NULL
Output : Linked list should be changed to,
       5->4->3->2->1->NULL

Input : NULL
Output : NULL

Input  : 1->NULL
Output : 1->NULL
*/



class Node {
    int value;
    Node next;
    Node(int value){
        this.value = value;
        next = null;
    } 
    
    public String toString(){
    	return "Node{value: " + value + "}";
    }
}

public class ReverseList {
	public static void main(String[] args){
        
        Node n5 = new Node (1);
        Node n4 = new Node (2);
        n4.next = n5;
        Node n3 = new Node (3);
        n3.next = n4;
        Node n2 = new Node (2);
        n2.next = n3;
        Node n1 = new Node (1);
        n1.next = n2;
        Node initial = n1;
        
        printList(initial);
		Node reversed = reverseList(initial );
		System.out.println("Reversed: " + reversed);
		printList(reversed);
		System.out.println("are palindromes? " + isPalindrome(initial));
    }	
    
    static void printList(Node node) {
    	Node current = node;
		while(current!=null){
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current);
		
	}

	public static Node reverseList(Node node){
        Node current = node;
        Node result = null;
        
        while(current!=null){ 
        	Node nodeAux = result;
        	result = new Node(current.value);
        	result.next=nodeAux;
            current = current.next;
        }
        
        return result;
    }
    
	static boolean isPalindrome(Node list1){
		boolean result = true;
		Node reversed = reverseList(list1);
		Node original = list1;
		
		while(original!=null || reversed!=null){
			if(original.value!=reversed.value){
				return false;
			}
			original = original.next;
			reversed = reversed.next;
		}
		
		return result;
	}
    
}
