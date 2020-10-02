/**
 * 231. Power of Two
Easy

1041

203

Add to List

Share
Given an integer n, write a function to determine if it is a power of two.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
Example 4:

Input: n = 4
Output: true
Example 5:

Input: n = 5
Output: false
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        long N = (long) n;
        return (N & (-N)) == N;
    }
}