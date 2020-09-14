class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //use TrieNode to traverse to set the isWord flag symbol
        TrieNode node = root;
        for(char c: word.toCharArray()){
            Map<Character, TrieNode> map = node.children;
            if(!map.containsKey(c))
                map.put(c, new TrieNode());

            node = map.get(c);
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            Map<Character, TrieNode> map = node.children;
            if(!map.containsKey(c))
                return false;

            node = map.get(c);
        }

        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            Map<Character, TrieNode> map = node.children;
            if(!map.containsKey(c))
                return false;
        }

        return true;
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isWord;

    TrieNode(){
        children = new HashMap<Character, TrieNode>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */