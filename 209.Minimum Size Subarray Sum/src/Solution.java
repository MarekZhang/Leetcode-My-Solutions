/*
209. Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
*/

public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        //create a sliding window [l...r]
        //do not initialize value; the initialzed value of sum should be zero
        int l = 0;
        int r = -1;
        int sum = 0;
        int N = nums.length;
        int window_len = N + 1; // initiate a window length which is unable to get out of bounds

        while( l < nums.length){
            if(r < N - 1 && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];

            if(sum >= s)
                window_len = window_len < (r - l + 1) ? window_len : (r - l + 1);
        }

        if(window_len == N + 1)
            return 0;
        
        return window_len;

    }

    public static void main(String[] args){
        int[] nums = {10,2,3};

        System.out.println(minSubArrayLen(6, nums));
    }
}