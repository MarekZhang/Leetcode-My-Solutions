class Solution {
    //time complexity O(N * 26^l) || space O(N) 52ms
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<String>(wordList);
    if(!set.contains(endWord)) return 0;
    
    LinkedList<String> queue = new LinkedList<String>();
    queue.addLast(beginWord);
    int step = 1;
    int len = beginWord.length();
    while(!queue.isEmpty()){
        step++;
        //bfs
        int size = queue.size();
        for(int i = 0; i < size; i++){ //elements in the same layer
            String str = queue.removeFirst();
            for(int j = 0; j < len; j++){
                char[] letters = str.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == str.charAt(j)) continue;
                    letters[j] = c;
                    String tempt = new String(letters);
                    if(tempt.equals(endWord)) return step;
                    if(set.contains(tempt)){
                        queue.addLast(tempt);
                        set.remove(tempt);
                    }
                }
            }
        }
    }

    return 0;
}
}