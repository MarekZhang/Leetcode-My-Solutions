/**
 * 55. Jump Game
Medium

5020

366

Add to List

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5

 */

class Solution {
    //time complexity O(N) || space complexity O(1)
    public boolean canJump(int[] nums) {
        //[0] is true || [0,1,2,3] is false
        if(nums[0] == 0)
            return nums.length == 1;
        
        int N = nums.length;
        for(int i = 1; i < N; i++){
            int move = nums[i] + i;
            nums[i] = nums[i - 1] > move ? nums[i - 1] : move;
            if(nums[i] >= N - 1)
                return true;
            if(nums[i] < i + 1 && i + 1 < N)
                return false;
        }
        
        return true;
    }
}