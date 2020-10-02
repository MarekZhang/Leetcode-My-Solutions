/**
 * 260. Single Number III
Medium

1865

118

Add to List

Share
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

1 <= nums.length <= 30000
 Each integer in nums will appear twice, only two integers will appear once.
 */
class Solution {
    //the problem can be solved by using a hashMap (number, freq)
    //time complexity O(n) | space complexity O(1)
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        //res = res1 ^ res2
        for(int i : nums)
            bitmask ^= i;

        //get the rightmost 1 bit of res, which represents the rightmost bit which res1 != res2
        int tempt = 0;
        int rightmost = bitmask & (~bitmask + 1);
        for(int i : nums)
            //结果为其中一个值，即时^=其他与bitmask最右1bit不为0的值，也会被出现的第二个相同值抵消掉
            if((i & rightmost) != 0)
                tempt ^= i;

        return new int[]{tempt, bitmask^=tempt};        
    }
}