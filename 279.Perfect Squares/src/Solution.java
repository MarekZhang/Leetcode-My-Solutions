/**
 * 279. Perfect Squares
Medium

2895

182

Add to List

Share
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
import java.util.*;
import javafx.util.*;

class Solution {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(n, 0));
        boolean[] visited = new boolean[n + 1];

        while(!queue.isEmpty()){
            Pair<Integer, Integer> temptPair = queue.removeFirst();
            int node = temptPair.getKey();
            int layer = temptPair.getValue();
            
            for(int i = 1;;i++){
                int a =  node - i * i;
                if(a < 0 )
                    break;
                if(a==0)
                    return layer + 1;
                if(!visited[a]){
                    queue.addLast(new Pair<Integer, Integer>(a, layer + 1));
                    visited[a] = true;
                }
            }
        }

        return -1;
    }
}