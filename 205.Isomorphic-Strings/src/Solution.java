// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true

import java.util.*;

class Solution{
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Character> charMap = new HashMap<>();

        for(int i =0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!charMap.containsKey(sChar) && charMap.containsValue(tChar))
                return false;
            else if(!charMap.containsKey(sChar))
                charMap.put(sChar, tChar);
            else{
                if(charMap.get(sChar) != tChar)
                    return false;
            }

        }

        return true;

    }

    public static void main(String args[]){
        String s = "paper";
        String t = "title";

        System.out.print(isIsomorphic(s, t));
    }
}