/*
3. Longest Substring Without Repeating Characters
Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int N = s.length();
        String subStr = "";
        int window = 0;

        while(l < N) {
            
            if(r < N - 1 && !subStr.contains(s.substring(r+1, r + 2))){
                subStr = s.substring(l, ++r + 1);//bound of substring method is [i,j)s
            }
            else
                subStr = s.substring(++l, r + 1);
            
            window = subStr.length() > window ? subStr.length() : window;
        }
            return window;
    }

    public static void main(String args[]){
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));

    }
}