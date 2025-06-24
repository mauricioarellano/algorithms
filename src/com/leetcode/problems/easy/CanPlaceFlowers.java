package com.leetcode.problems.easy;

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] dupbed = flowerbed;
        int flowers = n;
        for(int i=0; i<dupbed.length; i++){
            if(noAdjacents(dupbed, i)){
                dupbed[i] = 1;
                flowers--;
            }
            if(flowers<=0){
                return true;
            }
        }
        return false;
    }

    private boolean noAdjacents(int[] bed, int i){
        boolean leftFree = i == 0 || bed[i-1] == 0;
        boolean rightFree = (i == bed.length - 1) || bed[i+1] == 0;
        
        if(bed[i]==1){
            return false;
        }

        return leftFree && rightFree;
    }
}
  
