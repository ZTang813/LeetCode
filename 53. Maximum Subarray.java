class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length<1) return 0;
        int currsum = nums[0];
        int maxsum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            currsum = Math.max(currsum + nums[i], nums[i]);
            maxsum = Math.max(maxsum, currsum);

        }
        return maxsum;
    }
}
