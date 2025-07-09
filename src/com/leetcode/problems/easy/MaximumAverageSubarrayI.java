/*
* 643. Maximum Average Subarray I
* https://leetcode.com/problems/maximum-average-subarray-i/
*/

class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = getSum(nums, 0, k);
        int maxSum = sum;
        
        for(int i=k; i<nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    private int getSum(int[] nums, int start, int n){
        int sum = 0;
        for(int i=start; i<(start+n); i++){
            sum += nums[i];
        }
        return sum;
    }
}
