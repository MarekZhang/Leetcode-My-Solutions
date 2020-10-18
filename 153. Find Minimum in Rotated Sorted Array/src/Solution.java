/**
 * 153. Find Minimum in Rotated Sorted Array
Medium

2657

262

Add to List

Share
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */

class Solution {
    //time complexity O(log(n)) || space complexity O(1)
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0])
                left = mid + 1;
            else{
                min = nums[mid] < min ? nums[mid] : min;
                right = mid - 1;
            }
        }
        return min;
    }
}