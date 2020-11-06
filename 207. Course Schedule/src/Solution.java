/**
 * 207. Course Schedule
Medium

4673

197

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */

class Solution {
    private boolean[] marked;
    private boolean[] stack;
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    //time complexity O(E + V) || space complexity O(E + V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        stack = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][0];
            int nex = prerequisites[i][1];
            graph.computeIfAbsent(pre, (set) -> new ArrayList<>());
            graph.get(pre).add(nex);
        }
        
        for(int key : graph.keySet()){
            if(findDirectedCycle(key, graph.get(key)))
                return false;
        }
        
        return true;
    }
    
    private boolean findDirectedCycle(int w, List<Integer> vertexes){
        if(marked[w]) return false;
        if(stack[w]) return true;
        

        stack[w] = true;
        for(int vertex : vertexes){
            if(graph.containsKey(vertex) && findDirectedCycle(vertex, graph.get(vertex)))
                return true;
        }
        marked[w] = true;
        stack[w] = false;
        
        return false;
    }
}