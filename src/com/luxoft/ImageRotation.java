package com.luxoft;

/*
Image rotation:

Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees.


--------------------
| 1 * | 2*  | 3  | 4+ |
--------------------
| 12 | 13 | 14 | 5+ |
--------------------
| 11/ | 16 | 15 | 6 |
--------------------
| 10/ | 9  | 8 + | 7 -|
--------------------

--------------------
| 10 | 11 | 12 | 1 |
--------------------
| 9  | 16 | 13 | 2 |
--------------------
| 8  | 15 | 14 | 3 |
--------------------
| 7  | 6  | 5  | 4 |
--------------------
*/

public class ImageRotation {
	public static int[][] rotate(int[][] matrix){
	  	int n = matrix[0].length;
	    int[][] rotated = new int[n][];
	    int[] aux = null;
	    
	    for(int i=0; i<n; i++){
	    	aux = new int[n];
	      	for(int y=n-1, x=0; y>=0; y--, x++){
	      		aux[x] = matrix[y][i];
	     	}
	     	rotated[i] = aux;
	    }
	    return rotated;
	  }
	  
	  public static void print(int[][] matrix){
	  	int n = matrix[0].length;
	    for(int i=0; i<n; i++){
	      
	      for(int j=0; j<n; j++){
	        System.out.print(" " + matrix[i][j] + " ");
	      }
	      System.out.println("");
	    }
	  }
}
