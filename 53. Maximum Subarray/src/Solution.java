/**
 * 53. Maximum Subarray
Easy

9389

442

Add to List

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [0]
Output: 0
Example 4:

Input: nums = [-1]
Output: -1
Example 5:

Input: nums = [-2147483647]
Output: -2147483647
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
 */

class Solution {
    //time O(N) || space O(1)
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if(N == 0)
            return 0;
        //memo[0]represents the max sum we can get include nums[i];
        //memo[1]the sum we get if we take nums[i] as the new start of a subarray
        int[] memo = new int[2];
        int res = nums[0];
        memo[0] = nums[0];
        memo[1] = nums[0];
        for(int i = 1; i < N; i++){
            int prev0 = memo[0];
            int prev1 = memo[1];
            memo[0] = prev0 > prev1 ? nums[i] + prev0 : nums[i] + prev1;
            memo[1] = nums[i];
            res = memo[0] > res ? memo[0] : res;
            res = memo[1] > res ? memo[1] : res;
        }
        
        return res;
    }
}