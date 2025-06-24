
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int pointer = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            } else {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        for(int i=nums.length-count; i<nums.length; i++){
            nums[i]=0;
        }
    }
}
