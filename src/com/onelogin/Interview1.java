package com.onelogin;

import java.util.ArrayList;
import java.util.List;

/*
Write a function that, given a list and a target sum, 
returns zero-based indices of any two distinct elements whose sum is equal to the target sum. 
If there are no such elements, the function should return null.

For example, 
FindTwoSum(new List<int>() { 1, 3, 5, 7, 9 }, 12) should return a Tuple<int, int> containing any of 
the following pairs of indices:

1 and 4 (3 + 9 = 12)
2 and 3 (5 + 7 = 12)
3 and 2 (7 + 5 = 12)
4 and 1 (9 + 3 = 12)
*/

public class Interview1 {
 public static void main (String[] args) throws java.lang.Exception
 {
     //System.out.println("Hello Java");
     int[] numbers = { 1, 3, 5, 7, 9 };
     int total = 12;
     List result = findTwoSum(numbers, total);
     printResult(numbers, result);
 }
 
 
 public static List findTwoSum(int[] list, int total){
     List result = new ArrayList();
     for(int i=0; i<list.length; i++){
         for(int j=0; j<list.length; j++){
             if(sumElements(list, i,j) == total){
                 int[] tuple = {i,j};
                 result.add(tuple);
             }
         }
     }
     
     if(result.isEmpty()){
         return null;
     }
     return result;
 }
 
 static int sumElements(int[] array, int i,int j){
     return array[i] + array[j];
 }
 
 static void printResult(int[] array, List result){
     for(Object e:result){
         int[] tuple = (int[]) e;
         int i = tuple[0];
         int j = tuple[1];
         System.out.println(i + " and " + j + " (" + array[i] + " + " + array[j] + " = " + (array[i] + array[j]) + ")");
     }
 }
}

