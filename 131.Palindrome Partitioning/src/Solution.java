/**
 * 131. Palindrome Partitioning
Medium

1879

67

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length()==0)
            return res;

        List<String> palindrome = new ArrayList<>();
        dfs(s, 0, palindrome, res);

        return res;
    }

    private void dfs(String s, int index, List<String> palindrome , List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<String>(palindrome));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                palindrome.add(s.substring(index, i + 1));
                dfs(s, i + 1, palindrome, res);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s, int i, int j){
        if(i == j)
            return true;
        while(i < j){
            if(s.charAt(i++) - s.charAt(j--) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "efe";
        System.out.println(new Solution().partition(s));

    }
}