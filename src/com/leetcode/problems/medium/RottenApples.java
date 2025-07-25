/*
We are given a matrix where each cell can have one of three values:
* 0: empty cell
* 1: a fresh apple
* 2: a rotten apple

Every hour, any fresh apple that is 4-directionally adjacent to a rotten apple becomes rotten.

Return the *minimum number of hours* that must elapse until no cell has a fresh apple. If this is impossible, return `-1`.


Example 1: [[2,1,1],[1,1,0],[0,1,1]]

It takes 4 hours for all apples to become rotten. Output should be `4`.

2 1 1       2 2 1       2 2 2       2 2 2       2 2 2
1 1 0  ->   2 1 0   ->  2 2 0   ->  2 2 0   ->  2 2 0
0 1 1       0 1 1       0 1 1       0 2 1       0 2 2

Example 2: [[2,1,1],[0,1,1],[1,0,1]]

In this example, the left bottom corner apple is isolated and won't get rotten ever. Therefore it should return `-1`.

2 1 1       2 2 1       2 2 2       2 2 2       2 2 2
0 1 1   ->  0 1 1   ->  0 2 1   ->  0 2 2   ->  0 2 2
1 0 1       1 0 1       1 0 1       1 0 1       1 0 2

Example 3: [[0,2]]

In this example, all apples are already rotten, therefore it will return `0`.

0 2
 */


import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    
  public record Apple (int x, int y) {}
    
  public static int applesRotting(int[][] matrix){
    int result = -1;
    List<Apples> rottenApples = new ArrayList<Apple>();
    List<Apples> candidateRottenApples = new ArrayList<Apple>();
    List<Apples> freshApples = new ArrayList<Apple>();
    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j]==2){
                rottenApples.add(new Apple(i,j));
            } else if (matrix[i][j]==1){
                freshApples.add(new Apple(i,j));
            }
        }
    }
    if(rottenApples.empty()){
        return result;
    }
      
    foreach(Apple rotten: rottenApples){
        
    }
      
    return result;
  }
    
  public static void main(String[] args) {
      int[][] test1 = new int[][] {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
      };
      // [0,0]
      // [0,1], [1,0] => [0,0], [0,1], [1,0]
      // [0,2], [1,1] => [2,1]
      // [2,2]
      // 
      //System.out.println(applesRotting(test1));

      int[][] test2 = new int[][] {
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
      };
      //System.out.println(applesRotting(test2));

      int[][] test3 = new int[][] {
        {0, 2},
      };
      //System.out.println(applesRotting(test3));
  }
}
