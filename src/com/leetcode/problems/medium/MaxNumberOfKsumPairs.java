package com.leetcode.problems.medium;

// 1679. Max Number of K-Sum Pairs
// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

public class MaxNumberOfKsumPairs {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        int[] sumFound = findSum(nums, k);
        while(sumFound!= null){
            result++;
            
            nums = removeItems(nums, sumFound[0], sumFound[1]);
            if(nums==null){
                break;
            }
            sumFound = findSum(nums, k);
        }
        return result;
    }

    private int[] removeItems(int[] nums, int left, int right){
        int newLength = nums.length-2;
        if(newLength<2){
            return null;
        }
        int[] tmp = new int[newLength];
            for(int i=0, j=0; i<nums.length && j<newLength; i++){
                if(i!=left && i!=right){
                    tmp[j] = nums[i];
                    j++;
                }
            }
            return tmp;
    }

    private int[] findSum(int[] nums, int k){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if((nums[i]+nums[j])==k){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
