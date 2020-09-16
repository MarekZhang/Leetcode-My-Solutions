/**
 * 409. Longest Palindrome
Easy

1249

90

Add to List

Share
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consits of lower-case and/or upper-case English letters only.
 */

class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int offset = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++count);
        }

        for(Character c: map.keySet()){
            int count = map.get(c);
            if(count % 2 == 1)
                offset = 1;
            res += count / 2;
        }

        return res * 2 + offset;
    }
}