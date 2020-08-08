
class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];

        int preMax = nums[0];
        int curMax = Math.max(preMax, nums[1]);
        for(int i = 2; i < n; i++) {
            int tempt = curMax;
            curMax = Math.max(curMax, nums[i] + preMax);
            preMax = tempt;
        }

        return curMax;
    }
}