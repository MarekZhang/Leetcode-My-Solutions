/**
 * 91. Decode Ways
Medium

2753

2884

Add to List

Share
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

class Solution {
    //time complexity O(N) || space complexity O(N)
    public int numDecodings(String s) {
        int N = s.length();
        if(s == null || N == 0)
            return 0;
        int[] memo = new int[N + 1];
        memo[0] = s.charAt(0) == '0' ? 0 : 1;
        memo[1] = memo[0];
        for(int i = 2; i <= N; i++){
            //two digits number
            String digit1 = s.substring(i - 1, i);
            String digit2 = s.substring(i - 2, i);
            int val1 = Integer.valueOf(digit1);
            int val2 = Integer.valueOf(digit2);
            //the most significant bit cannot be zero
            if(val1 != 0){
                if(val2 > 10 && val2 <=26)
                    memo[i] = memo[i - 1] + memo[i - 2];
                else
                    memo[i] = memo[i - 1];
            }else{
                if(val2 > 20 || val2 == 0)
                    return 0;
                else
                    memo[i] = memo[i - 2];
            }
        }
        
        return memo[N];
    }
}