/**
 * 121. Best Time to Buy and Sell Stock
Easy

6427

276

Add to List

Share
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

class Solution {
    //dp time complexiy O(N) || space complexity O(N)
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N <= 1)
            return 0;
        //memo[i][0] represents the best price to buy one share of the stock till now, memo[i][1] max profit
        int[][] memo = new int[N][2];
        memo[0][0] = prices[0];
        memo[0][1] = 0;
        
        for(int i = 1; i < prices.length; i++){
            memo[i][0] = prices[i] < memo[i-1][0] ? prices[i] : memo[i-1][0];
            memo[i][1] = prices[i] - memo[i-1][0] > memo[i-1][1] ? prices[i] - memo[i-1][0] : memo[i-1][1];
        }
        
        return memo[N-1][1];
    }
}