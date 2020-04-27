/* 76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

import java.util.*;

public class Solution {
  public static String minWindow(String s, String t) {
    if(s.length()==0 || t.length()==0)
      return "";

    Map<Character, Integer> subDict = new HashMap<Character, Integer>();

    for(int i =0; i < t.length(); i++){
      int count = subDict.getOrDefault(t.charAt(i), 0);
      subDict.put(t.charAt(i), count + 1);
    }

    int l, r;
    l = r = 0;
    int lenOfSubStr = Integer.MAX_VALUE;
    int[] pointer = {-1, -1};
    //count the unique number of characters in substring
    int required = subDict.size();
    //use to count how many characters found in current sliding window 
    int hasFound = 0;

    Map<Character, Integer> strMap = new HashMap<Character, Integer>();
    
    while(r < s.length()){
      int count = strMap.getOrDefault(s.charAt(r), 0);
      strMap.put(s.charAt(r), count + 1);

      //if current window contains the same number of current character at 'r', then hasFound++
      if(subDict.containsKey(s.charAt(r)) && subDict.get(s.charAt(r)).equals(strMap.get(s.charAt(r))))
        hasFound++;
      // else if(subDict.containsKey(s.charAt(r)) && subDict.get(s.charAt(r)) < strMap.get(s.charAt(r))){
      //   int countL = strMap.get(s.charAt(l));
      //   strMap.put(s.charAt(l), countL - 1);

      //   if(subDict.containsKey(s.charAt(l)) && subDict.get(s.charAt(l)) > strMap.get(s.charAt(l)))
      //     hasFound --;
      //   l++;
      // }
      while(l <= r && hasFound == required){
        if((r - l + 1) < lenOfSubStr){
          pointer[0] = l;
          pointer[1] = r;
          lenOfSubStr = r - l + 1;
        }
        int countL = strMap.get(s.charAt(l));
        strMap.put(s.charAt(l), countL - 1);
        if(subDict.containsKey(s.charAt(l)) && subDict.get(s.charAt(l)) > strMap.get(s.charAt(l)))
          hasFound --;
        l++;

      }

      r++;
    }

    return lenOfSubStr == Integer.MAX_VALUE ? "" : s.substring(pointer[0], pointer[1] + 1);

  }
     public static void main(String[] args){
      String s = "ABAACBAB";
      String t = "ABC";
      System.out.println(minWindow(s, t));
     }
}
