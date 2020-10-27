/**
 * 567. Permutation in String
Medium

1882

71

Add to List

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        
        //if s1Map == s2Map, find the permutation
        int p1 = 0;
        int p2 = p1 + s1.length();
        while(p2 < s2.length()){
            if(matches(s1Map, s2Map))
                return true;
            s2Map[s2.charAt(p1++) - 'a']--;
            s2Map[s2.charAt(p2++) - 'a']++;
        }
        
        return matches(s1Map, s2Map);
    }
    
    private boolean matches(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}