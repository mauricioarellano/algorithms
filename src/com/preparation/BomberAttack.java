/*
https://sharepad.io/p/Fy5C8hh

We are creating a video game in which aliens are attacking a friendly base.
You can imagine the base to be a 1D line that goes from 0 to n.
The alien's attack length is always 1, but they can choose to attack anywhere along the base.
We are trying to implement two functions for the video game: ⁠ attack ⁠ and ⁠ isGameOver ⁠.

For the ⁠ attack ⁠ function, it takes a number from 0 to n, and should mark the corresponding place to start the attack.
For example, if ⁠ an attack ⁠ is called with 3, then the line subset 3-4 should be marked as destroyed.

For the ⁠ isGameOver ⁠ function, it should return a ⁠ boolean ⁠, which indicates whether the entire base has been
destroyed.

* Example *

Imagine the following sequences of calls:

b = Base(10)
b.attack(0)           -> segment 0-1 is attacked
b.attack(1)           -> segment 1-2 is attacked
b.attack(2)           -> segment 2-3 is attacked
b.attack(3)           -> segment 3-4 is attacked
b.attack(4)           -> segment 4-5 is attacked
b.isGameOver()        -> return false
b.attack(5)           -> segment 5-6 is attacked
b.attack(6)           -> segment 6-7 is attacked
b.attack(7)           -> segment 7-8 is attacked
b.attack(8)           -> segment 8-9 is attacked
b.attack(9)           -> segment 9-10 is attacked
b.isGameOver()        -> return true

*/

import java.util.*;

class Main {


    public static class Base {
        private int[] segments;
        private int safeSegments;
        
        public Base(int size) {
            segments = new int[size];
            safeSegments = size;
        }

        private void performAttack(int start){
            if(start >= segments.length){
                return;
            }
            
            if(segments[start]==0){
                safeSegments--;
                segments[start] = 1;
            }
        }
        
        public void attack(Number start) {
            performAttack(start.intValue());
            performAttack(start.intValue()+1);
        }

        public boolean isGameOver() {
            return safeSegments > 0;
        }

    }

    public static void test1() {
        Base b = new Base(10);
        b.attack(0);
        b.attack(1);
        b.attack(2);
        b.attack(3);
        b.attack(4);
        b.attack(5);
        b.attack(6);
        b.attack(7);
        b.attack(8);
        assert !b.isGameOver();
        b.attack(9);
        assert b.isGameOver();
    }


    public static void main(String[] args) {

        test1();

        System.out.println("Success!");
    }
}
