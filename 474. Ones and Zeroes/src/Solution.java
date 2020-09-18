/**
 * 474. Ones and Zeroes
Medium

1136

248

Add to List

Share
Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
 */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0)
            return 0;

        int[][] memo = new int[m + 1][n + 1];
        //convert str into a pair recors the number of '0' and '1'
        for(String str: strs){
            int numOfZero = 0;
            int numOfOne = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '0') 
                    numOfZero++;
                else
                    numOfOne++;
            }
            for(int zero = m; zero >= numOfZero; zero--){
                for(int one = n; one >= numOfOne; one--)
                    memo[zero][one] = Math.max(memo[zero][one], memo[zero - numOfZero][one - numOfOne] + 1);
            }
        }

        return memo[m][n];
    }
}