/*
 * Click `Run` to execute the snippet below!

Design a minimum stack, that allows

* Adding integer
* Deleting integer
* Getting the integer at the top of the stack
* Getting the minimum integer of the stack

 */

import java.io.*;
import java.util.*;

class MinStack {

  Stack<Integer> values = new Stack<Integer>();
  Stack<Integer> min = new Stack<Integer>();
  // Stack<Integer> min = new Stack<List<Integer, Integer>>(); // Enhancement for threadsafe

  // Adding integer
  public void pushMin(int value){ // O(1)
    values.push(value);
    if(min.isEmpty() || value.comparator <= 0 min.peek()){
      min.push(value);
    } else {
      min.push(min.peek());
    }

  }

  // Deleting integer
  public int popMin(){ // O(1)
    min.pop();
    return values.pop();
  }

  // Getting the integer at the top of the stack
  public int top(){ // O(1)
    return values.peek();
  }

  // Getting the minimum integer of the stack
  public int min(){ // O(1)
    return min.peek();
  }

  public static void main(String[] args) {
    
  }
}
