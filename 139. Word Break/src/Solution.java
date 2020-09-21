/**
 * 139. Word Break
Medium

4965

246

Add to List

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //memo[i] represents s.substring(0, i+1) can be segmented into the dictionary words
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;

        for(int len = 1; len <= s.length(); len++){
            for(String str: wordDict){
                if(len >= str.length() && memo[len - str.length()] == true){
                    if(str.equals(s.substring(len - str.length(), len))){
                        memo[len] = true;
                        break;
                    }
                }
            }
        }

        return memo[n];
    }
}