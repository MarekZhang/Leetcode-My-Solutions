/**
 * 127. Word Ladder
Medium

3059

1148

Add to List

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
import java.util.*;
import javafx.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));

        while(!queue.isEmpty()){
            Pair<String, Integer> temptPair = queue.removeFirst();
            String word = temptPair.getKey();
            int freq = temptPair.getValue();
            for(String str: wordList){
                if(similar(word, str)){
                    if(str.equals(endWord))
                        return freq + 1;
                    queue.addLast(new Pair<String, Integer>(str, freq + 1));
                    visited.add(str);
                }
            }

            for(String str:visited){
                wordList.remove(str);
            }
        }
        
        return 0;
    }

    private boolean similar(String word1, String word2){
        if(word1.length()!=word2.length())
            throw new IllegalArgumentException();
        int diff = 0;
        for(int i = 0; i < word1.length(); i++)
            if(word1.charAt(i) != word2.charAt(i))
                diff++;
    
        if(diff == 1)
            return true;
        
        return false;
    }

    public static void main(String[] args){
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        int b = new Solution().ladderLength("hit", "cog", list);
        System.out.println(b);
    }
}