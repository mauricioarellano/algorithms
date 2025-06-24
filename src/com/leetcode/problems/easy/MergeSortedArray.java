// 88. Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        if(n==0){
            return;
        }

        if(m==0 && n>0){
            for(int i=0; i<n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        if(nums2[0] > nums1[m-1]){
            for(int i=m, j=0; i<nums1.length && j<nums2.length; i++, j++){
                nums1[i] = nums2[j];
            }
            return;
        }

        for(int i=0, p1=0, p2=0; i<result.length; i++){
            if(p1<m && p2>=n){
                result[i] = nums1[p1];
                p1++;
                continue;
            }
            if(p2<n && p1>=m){
                result[i] = nums2[p2];
                p2++;
                continue;
            }
            if(nums1[p1] < nums2[p2]){
                result[i] = nums1[p1];
                p1++;
            } else {
                result[i] = nums2[p2];
                p2++;
            }
        }

        for(int i=0; i<result.length; i++){
            nums1[i] = result[i];
        }
    }
}
