/**
 * 208. Implement Trie (Prefix Tree)
Medium

3648

56

Add to List

Share
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
 */

class Trie {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    private TrieNode root;
    private Character endSymbol = '*';
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        for(int i = 1; i < word.length(); i++){
            Map<Character, TrieNode> map = root.children;
            for(int j = 0; j < i; j++){
                char tempt = word.charAt(j);
                if(map.containsKey(tempt))
                    ;
                else
                    map.put(tempt, new TrieNode());
                map = map.get(tempt).children;
            }
            map.put(endSymbol, null);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Map<Character, TrieNode> map = root.children;
        for(int i = 0; i < word.length(); i++){
            char tempt = word.charAt(i);
            if(!map.containsKey(tempt))
                return false;
            
            map = map.get(tempt).children;
        }

        return map.containsKey(endSymbol);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Map<Character, TrieNode> map = root.children;
        for(int i = 0; i< word.length(); i++){
            char tempt = prefix.charAt(i);
            if(!map.containsKey(tempt))
                return false;

            map = map.get(tempt).children;
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */