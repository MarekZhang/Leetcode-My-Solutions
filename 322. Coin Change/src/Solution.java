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
      if(amount == 0)//not reasonable
          return 0;
        
      if(amount < 0 || coins.length == 0)
        return -1;
  
      //memo[value] represents the minimum amount of coins needed for filling the value
      int[] memo = new int[amount + 1];
      // Arrays.fill(memo, -1); cannot fill will -1, memo[0] 用来判断当前面值是否正好填充
      //1.use conis[0] merely finding amount of coins
      for(int a = 1; a <= amount; a++)
        memo[a] = a % coins[0] == 0 ? a / coins[0] : -1;
  
      //2.update memo
      for(int i = 1; i < coins.length; i++)
        //no need to update when amount is lower than coins[i]
        for(int a = coins[i]; a <= amount; a++){
          //if(memo[a - coins[i]] == -1) cannot update memo[a]
          if(memo[a - coins[i]] != -1){
            if(memo[a] == -1)
              memo[a] = memo[a - coins[i]] + 1;
            else
              memo[a] = Math.min(memo[a], memo[a - coins[i]] + 1);
          }
        }
  
      return memo[amount];
    }
  }