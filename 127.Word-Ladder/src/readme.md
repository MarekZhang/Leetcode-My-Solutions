# 127. Word Ladder

![127%20Word%20Ladder%2097a367fea8934f18a7c57a40ab32df51/Untitled.png](127%20Word%20Ladder%2097a367fea8934f18a7c57a40ab32df51/Untitled.png)

### Solution

1. we can build up an undirected graph which connect two words together if they are similar(with one letter difference). Then we use BFS to search the whole graph. Time complexity O(N^2*l). Maintaining HashMap in Java usually bring in expensive cost, so this algorithm does not perform efficiently.

    ```java
    class Solution {
    		//time complexity O(N^2*L) || space comlexity O(N^2) 2000+ms
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, ArrayList<String>> graph = new HashMap<>();
            wordList.add(beginWord);
            int size = wordList.size();
            for(int i = 0; i < size; i++){
                String v = wordList.get(i);
                graph.put(v, new ArrayList<>());
                for(int j = 0; j < size; j++){
                    if(j == i) continue;
                    String w = wordList.get(j);
                    if(similar(v, w))
                        graph.get(v).add(w);
                }
            }

            //bfs
            LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            visited.add(beginWord);
            queue.addLast(new Pair<>(beginWord, 1));
            while(!queue.isEmpty()){
                Pair<String, Integer> pair = queue.removeFirst();
                String word = pair.getKey();
                int step = pair.getValue();
                for(String str : graph.get(word)){
                    if(str.equals(endWord)) return step + 1;
                    else if(!visited.contains(str)){
                        queue.addLast(new Pair<>(str, step + 1));
                        visited.add(str);
                    } 
                }
            }

            return 0;
            
        }

        private boolean similar(String v, String w){
            int count = 0;
            int len = v.length();
            for(int i = 0; i < len; i++)
                if(v.charAt(i) != w.charAt(i)) count++;

            return count <= 1;
        }
    }
    ```

2. The second algorithm is a sort of brute force solution. Start from the begin word, we replace each position with the letters from 'a' to 'z' and see if there is an identical word in the given list. If so, we add the word in the queue and remove the word from the given list(***the first time we find the word in the list, is the shortest path we can find it***)

    ```java
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
    ```