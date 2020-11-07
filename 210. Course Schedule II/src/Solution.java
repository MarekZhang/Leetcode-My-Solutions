/**
 * 210. Course Schedule II
Medium

2897

150

Add to List

Share
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */

class Solution {
    private boolean[] visited;
    private boolean[] visiting;
    private Stack<Integer> stack = new Stack<>();
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    //time O(V + E)|| space O(V + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      visited = new boolean[numCourses];
      visiting = new boolean[numCourses];
  
      //build the graph
      for(int i = 0; i < prerequisites.length; i++){
        int key = prerequisites[i][1];
        graph.computeIfAbsent(key, (list) -> new ArrayList<>());
        graph.get(key).add(prerequisites[i][0]);
      }
  
      for(int vertex : graph.keySet()){
        if(!visited[vertex])
          if(hasDirectedCycle(vertex, graph.get(vertex)))
            return new int[0];
      }
      int[] order = new int[numCourses];
      int i = 0;
      while(!stack.isEmpty()){
          order[i++] = stack.pop();
      }      
      for(int j = 0; j < numCourses; j++){
        if(!graph.containsKey(j))
          order[i++] = j;
      }
  
      return order;
    }
  
    private boolean hasDirectedCycle(int vertex, List<Integer> adjMatrix){
      if(visited[vertex]) return false;
      if(visiting[vertex]) return true;
  
      visiting[vertex] = true;
      //preorder
  
      for(int vex : adjMatrix){
        if(!visited[vex] && graph.containsKey(vex) && hasDirectedCycle(vex, graph.get(vex)))
          return true;
      }
      //dfs遍历到底的vertex先入栈; vertex退出调用栈
      stack.push(vertex);
      visited[vertex] = true;
      visiting[vertex] = false;
  
      return false;
    }
  }