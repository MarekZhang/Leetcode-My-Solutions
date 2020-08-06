/**
 * 198. House Robber
Easy

4988

154

Add to List

Share
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400
 */

class Solution2 {

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;

        int[] memo = new int[len + 2];
        Arrays.fill(memo, -1);
        //the len index is out of nums, so we set the value as 0
        memo[len] = 0;
        memo[len + 1] = 0;
        memo[len -1] = nums[len - 1];

        //memo[i] represents the maximum value robbed from [i...n-1] houses
        for(int i = len - 2; i >= 0; i--)
            for(int j = i; j < len; j++)
                memo[i] = Math.max(memo[i], nums[j] + memo[j + 2]);

        return memo[0];
    }
}