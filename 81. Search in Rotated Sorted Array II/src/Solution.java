/**
 * 81. Search in Rotated Sorted Array II
Medium

1563

495

Add to List

Share
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

 */

class Solution {
    //worst case [1,1,1,1,1,1] time complexity O(1) || space complexity O(1)
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        
        int left = 0;
        int right = nums.length - 1;

        while(nums[right] == nums[0] && right > left)
            right --;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] >= nums[left]){
                if( target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }
}