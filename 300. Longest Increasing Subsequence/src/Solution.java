/**
 * 300. Longest Increasing Subsequence
Medium

5433

121

Add to List

Share
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */

//1. what if a == b?
//time O(n^2) || space O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0)
            return 0;
        if(n == 1)
            return 1;
            
        //memo[i] represents the longest increase sequence length with the array ends with nums[i]
        int memo[] = new int[n];
        Arrays.fill(memo, 1);
        int maxLIS = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && memo[i] <= memo[j]){
                    memo[i] = memo[j] + 1;
                    maxLIS = maxLIS > memo[i] ? maxLIS : memo[i];
                }
            }
        }

        return maxLIS;
    }
}