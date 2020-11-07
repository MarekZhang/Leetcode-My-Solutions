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
    private boolean[] visited;
    private boolean[] visiting;
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];
        //build the graph
        for(int i = 0; i < prerequisites.length; i++){
            int key = prerequisites[i][1];
            graph.computeIfAbsent(key, (list) -> new ArrayList<>());
            graph.get(key).add(prerequisites[i][0]);
        }
        
        for(int key : graph.keySet()){
            if(!visited[key])
                if(findDirectedCycle(key, graph.get(key)))
                    return false;
        }
        
        return true;
    }
    
    private boolean findDirectedCycle(int vertex, List<Integer> adjMatrix){
        if(visited[vertex]) return false;
        if(visiting[vertex]) return true;
        
        visiting[vertex] = true;
        for(int vert : adjMatrix){
            if(!visited[vert])
                if(graph.containsKey(vert) && findDirectedCycle(vert, graph.get(vert)))
                    return true;
        }
        
        visiting[vertex] = false;
        visited[vertex] = true;
        
        return false;
    }
}