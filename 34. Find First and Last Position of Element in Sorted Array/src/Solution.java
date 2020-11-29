/**
 * 34. Find First and Last Position of Element in Sorted Array
Medium

4487

178

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
class Solution {
    private int pos1, pos2;
    //time complexity O(logN) || space complexity O(1)
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        if(nums == null || N == 0)
            return new int[]{-1, -1};
        pos1 = pos2 = -1;
        binarySearch(nums, 0, N - 1, target);
        return new int[]{pos1, pos2};
    }
    
    public void binarySearch(int[] nums, int l, int r, int target){
        if(l > r) return;
        int middle = l + (r - l) / 2;
        if(nums[middle] == target){
            if(pos1 == -1) pos1 = middle;
            else pos1 = Integer.min(pos1, middle);
            
            if(pos2 == -1) pos2 = middle;
            else pos2 = Integer.max(pos2, middle);
            
            //search in left range in order to find smaller pos1
            binarySearch(nums, l, middle - 1, target);
            //search in right range in order to find bigger pos2
            binarySearch(nums, middle + 1, r, target);
        }else if(nums[middle] > target){
            binarySearch(nums, l, middle - 1, target);
        }else{
            binarySearch(nums, middle + 1, r, target);
        }
    }
}