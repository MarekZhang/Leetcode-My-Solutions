/**
 * 1202. Smallest String With Swaps
Medium

670

24

Add to List

Share
You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 

Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"
Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"
 

Constraints:

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
 */

class Solution {
    class UF{
        int[] id;
        int[] sz;
        
        public UF(int N){
            id = new int[N];
            sz = new int[N];
            for(int i = 0; i < N; i++){
                id[i] = i;
                sz[i] = 1;
            }
        }
        public int find(int p){
            while(id[p] != p) p = id[p];
            
            return p;
        }
        
        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
        
        public void union(int p, int q){
            int i = find(p);
            int j = find(q);
            if(i == j) 
                return;
            
            if(sz[i] > sz[j]){
                id[j] = i;
                sz[i] += sz[j];
            }else{
                id[i] = j;
                sz[j] += sz[i];
            }
        }
    }
    //time complexity O(NlogN) || space complexity O(N)
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int N = s.length();
        //key is the root, value contains ordered characters  
        Map<Integer, PriorityQueue<Character>> graphs = new HashMap<>();
        
        //Union find
        UF uf = new UF(N);
        for(int i = 0; i < pairs.size(); i++){
            uf.union(pairs.get(i).get(0), pairs.get(i).get(1));
        }
        
        for(int i = 0; i < N; i++){
            int component = uf.find(i);
            graphs.computeIfAbsent(component, (list) -> new PriorityQueue<>());
            //characters in the same component would be automatically ordered by the Heap
            graphs.get(component).add(s.charAt(i));
        }
        
        StringBuilder builder = new StringBuilder();
        //time complexity O(NlogN)
        for(int i = 0; i < N; i++){
            int component = uf.find(i);
            builder.append(graphs.get(component).poll());
        }
        
        return builder.toString();
    }
}