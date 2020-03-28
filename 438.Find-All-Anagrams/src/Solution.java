/*
438. Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

import java.util.*;

public class Solution{
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> positionList = new ArrayList<>();

        int LenS = s.length();
        int LenP = p.length();

        if(LenS < LenP)
            return positionList;

        int[] charPos = new int[26];
        // //postition of target String
        int[] PPos = new int[26];
        for(char c : p.toCharArray())
            PPos[c - 'a'] += 1; //注意不是=1 而是 += 1
        
        //initiate the first k (the length of p) position in String s
        for(int i = 0; i < LenP; i++)
            charPos[s.charAt(i) - 'a'] += 1;//注意不是=1 而是 += 1
        if(Arrays.equals(charPos, PPos))
            positionList.add(0);
        
        for(int j = 0; j < LenS - LenP;){       
            charPos[s.charAt(j++) - 'a'] --;
            charPos[s.charAt(j + LenP - 1) - 'a'] ++;

            if(Arrays.equals(charPos, PPos))
            positionList.add(j);
        }
        
        return positionList;

    }

    public static void main(String args[]){
        String s = "abacbabc";
        String p = "abc";
        List<Integer> pos = findAnagrams(s, p);

        for(Integer t: pos)
            System.out.println(t);
    }
}