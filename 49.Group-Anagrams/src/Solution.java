/**49. Group Anagrams
Medium

3236

168

Add to List

Share
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter. */

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(String s: strs){
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String temptKey = String.valueOf(strArr);

            if(!map.containsKey(temptKey))
                map.put(temptKey, new ArrayList<String>());
            
            map.get(temptKey).add(s);
            
        }

    return new ArrayList(map.values());
    }
}