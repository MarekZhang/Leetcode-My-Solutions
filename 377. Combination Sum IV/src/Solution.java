/**
 * 377. Combination Sum IV
Medium

1570

192

Add to List

Share
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0)
            return 1;
        if(nums == null || nums.length == 0)
            return 0;
            
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for(int t = 1; t <= target; t++)
            for(int i = 0; i < nums.length; i++){
                if(t >= nums[i])
                    memo[t] += memo[t - nums[i]];
            }
        
        return memo[target];
    }
}