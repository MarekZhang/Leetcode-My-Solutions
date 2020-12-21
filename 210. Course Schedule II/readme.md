# 210. Course Schedule II

![210%20Course%20Schedule%20II%203380c95ea2fd4900b4a32db838e46d45/Untitled.png](210%20Course%20Schedule%20II%203380c95ea2fd4900b4a32db838e46d45/Untitled.png)

### Solution

- we need to find if the graph is DAG and simultaneously store traversed elements in reverse post order.
- an auxiliary array named `visit` is used for storing visit status: 0 represents not visited; 1 means visited and 2 represents visiting

```java
class Solution {
    private boolean flag = true;
    private Stack<Integer> stack = new Stack<Integer>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
        //build graph
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < prerequisites.length; i++){
            int course1 = prerequisites[i][0];
            int course2 = prerequisites[i][1];
            //take course2 before course1
            graph[course2].add(course1);
        }
        
        //0 not visited; 1 visited; 2 visiting
        int[] visit = new int[numCourses];
        //dfs
        for(int i = 0; i < numCourses; i++){
            if(visit[i] != 1){
                dfs(graph, i, visit);
            }
        }
        if(!flag) return new int[]{};

        int[] res = new int[numCourses];
        int idx = 0;
        while(!stack.isEmpty())
            res[idx++] = stack.pop();
        
        return res;
    }

    private void dfs(ArrayList<Integer>[] graph, int course, int[] visit){
        if(visit[course] == 2){
            flag = false;
            return;
        }

        visit[course] = 2;
        for(int c : graph[course]){
            if(visit[c] != 1)
                dfs(graph, c, visit);
        } 
        stack.push(course);
        visit[course] = 1;
    }
}
```