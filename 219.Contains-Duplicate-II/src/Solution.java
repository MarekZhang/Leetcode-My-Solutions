/**219. Contains Duplicate II
Easy

771

938

Add to List

Share
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

import java.util.*;
//sliding window with HashSet
class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            //store maximum k values
            //k个值和角标差为k 相差 1 个值
            if(set.size() == k + 1)
                set.remove(nums[i - k]); //剩余 i - (i-k)个值
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,3};
        System.out.println( containsNearbyDuplicate(nums, 2));
    }
}