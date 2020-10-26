/**
 * 1143. Longest Common Subsequence
Medium

1891

25

Add to List

Share
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */

class Solution {
    //charAt(m)== charAt(n) -- LCS(m,n) = 1 + LCS(m-1, n-1) 
    //charAt(m)!= charAt(n) --  max(LCS(m, n-1), LCS(m-1, n))
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
      if(text1 == null || text2 == null || text1.length()== 0 || text2.length()== 0)  
        return 0;
      
      //memo[m][n] represents the LCS value between text1.substring(0, m) and text2.substring(0,n)
      memo = new int[text1.length()][text2.length()];
      for(int i = 0; i < text1.length(); i++)
        Arrays.fill(memo[i], -1);

      return LCS(text1, text2);
    }

    private int LCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m == 0 || n == 0)
            return 0;

        if(memo[m - 1][n - 1] != -1)
            return memo[m - 1][n - 1];

        if(text1.charAt(m - 1) == text2.charAt(n - 1))
            memo[m - 1][n - 1] = 1 + LCS(text1.substring(0, m - 1), text2.substring(0, n - 1));
        else
            memo[m -1][n - 1] = Math.max(LCS(text1.substring(0, m-1), text2), LCS(text1, text2.substring(0, n-1)));
        
        return memo[m - 1][n - 1];
    }
}


class Solution {
  int[][] memo;
  String str1;
  String str2;
  
  public int longestCommonSubsequence(String text1, String text2) {
      if(text1.length() == 0 || text2.length() == 0)
          return 0;
      memo = new int[text1.length()][text2.length()];
      for(int[] arr : memo)
          Arrays.fill(arr, -1);
      str1 = text1;
      str2 = text2;
      
      return LCS(0, 0);
  }
  
  private int LCS(int idx1, int idx2){
      if(memo[idx1][idx2] != -1)
          return memo[idx1][idx2];
      
      int letterExcluded = LCS(idx1 + 1, idx2);
      
      int letterIncluded = 0;
      int pos = str2.indexOf(str1.charAt(idx1), idx2);
      if(pos != -1)
          letterIncluded = LCS(idx1 + 1, pos + 1) + 1;
          
      memo[idx1][idx2] = Math.max(letterExcluded, letterIncluded);
      
      return memo[idx1][idx2];
  }
}