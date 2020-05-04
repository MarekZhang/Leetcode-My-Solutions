// Given two strings s and t , write a function to determine if t is an anagram of s.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
import java.util.*;

class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        if(s.equals("") || t.equals(""))
            return true;

        Map<Character, Integer> charMap = new HashMap<>();

        for(int i =0; i < s.length(); i++){
            int count = charMap.getOrDefault(s.charAt(i), 0);
            charMap.put(s.charAt(i), count + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char tempt = t.charAt(i);
            if(!charMap.containsKey(tempt))
                return false;
            int count = charMap.get(tempt) - 1;
            if(count == 0)
                charMap.remove(tempt);
            else
                charMap.put(tempt, count);
        }

        if(charMap.isEmpty())
            return true;
        
        return false;
    }

    public static void main(String args[]){
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));
    }


} 