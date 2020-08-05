/**
 * 279. Perfect Squares
Medium

2895

182

Add to List

Share
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

class Solution2 {
    public int numSquares(int n) {
        if( n == 0)
            return 0;

        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = 1; i - j * j >= 0; j++){
                int diff = i - j * j;
                memo[i] = Math.min(memo[diff] + 1, memo[i]);
            }
        
        return memo[n];

    }

}