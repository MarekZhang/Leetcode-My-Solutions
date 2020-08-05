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
    private int res;
    public int numDecodings(String s) {
        if(s.length() == 0 || s == null)
            return 0;
        int n = s.length();
        int[] memo = new int[n + 1];

        int[1] = s.charAt(0) != '0' ? 1 : 0;

        for(int i = 2; i <= n; i++){
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if(first >= 1 && first <= 9)
                memo[i] += memo[i - 1];
            if(second >= 10 && second <= 26)
                memo[i] += memo[i - 2];
        }

        return memo[n];
    }
}