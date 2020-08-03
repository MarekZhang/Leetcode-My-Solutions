/**
 * 343. Integer Break
Medium

1072

226

Add to List

Share
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */

class Solution {
    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        memo[1] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = 1; j <= i -1; j++)
                memo[i] = max3(memo[i], i * (i - j), i * memo[i - j]);

        return memo[n];
    }

    private int max3 (int x, int y, int z){
        return Math.max(x, Math.max(y, z));
    }
}