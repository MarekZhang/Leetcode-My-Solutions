// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

// Example 1:

// Input: pattern = "abba", str = "dog cat cat dog"
// Output: true
// Example 2:

// Input:pattern = "abba", str = "dog cat cat fish"
// Output: false
// Example 3:

// Input: pattern = "aaaa", str = "dog cat cat dog"
// Output: false
// Example 4:

// Input: pattern = "abba", str = "dog dog dog dog"
// Output: false
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.

import java.util.*;

public class Solution{
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> charStrMap = new HashMap<>();
        String[] strArr = str.split(" ");
        //essential "aaa" "aa aa aa aa"
        if(pattern.length() != strArr.length)
            return false;

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String value = strArr[i];
            if(charStrMap.containsKey(c)){
                String tempt = charStrMap.get(c);
                if(!tempt.equals(value))
                    return false;
            }else if(!charStrMap.containsKey(c) && charStrMap.containsValue(value)){ 
                return false;
            }
            else
                charStrMap.put(c, strArr[i]);
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
    }
}