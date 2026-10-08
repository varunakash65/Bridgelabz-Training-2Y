package Arrays.Leetcode;

public class LC268 {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i){
                    return i;
                }
            }
            return nums.length;
        }
    }
}
