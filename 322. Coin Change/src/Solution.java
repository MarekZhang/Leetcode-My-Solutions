/**
 * 322. Coin Change
Medium

4875

149

Add to List

Share
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.


 */


class Solution {
  public int coinChange(int[] coins, int amount) {
      if(coins == null)
          return -1;
      int[] memo = new int[amount + 1];
      Arrays.fill(memo, -1);
      memo[0] = 0;
      
      for(int i = 0; i < coins.length; i++){
          int denom = coins[i];
          for(int j = denom; j <= amount; j++){
              // if(memo[j] == -1 && memo[j - denom] == -1)
              //     memo[j] = -1;
              // else if(memo[j] == -1)
              //     memo[j] = memo[j - denom] + 1;
              // else if(memo[j - denom] == -1)
              //     ;
              // else
              //     memo[j] = memo[j] < (memo[j - denom] + 1) ? memo[j] : (memo[j - denom] + 1);
              if(memo[j - denom] != -1){
                  if(memo[j] == -1)
                      memo[j] = memo[j - denom] + 1;
                  else
                      memo[j] = memo[j] < (memo[j - denom] + 1) ? memo[j] : (memo[j - denom] + 1);
              }
          }
      }

      
      return memo[amount];
  }
}