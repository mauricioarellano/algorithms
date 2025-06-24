
//238. ProductOfArrayExceptSelf
class ProductOfArrayExceptSelf {
  // Brute force: Time Limit Exceeded on 70000-elements array
  public int[] productExceptSelfTimeLimitExceeded(int[] nums) {
        //System.out.println(nums.length);
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int prod = 1;
            for(int j=0; j<nums.length; j++){
                if(j==i){
                    continue;
                }
                if(nums[j]==0){
                    prod = 0;
                    break;
                }
                prod *= nums[j];
            }
            result[i] = prod;
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zerocount = 0;
        boolean zerofound = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0 && !zerofound){
                zerocount++;
                zerofound = true;
                continue;
            }
            product *= nums[i];
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                result[i] = product;
            } else if(zerocount>0){
                result[i] = 0;
            } else {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}
