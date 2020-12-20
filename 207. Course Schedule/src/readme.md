# 207. Course Schedule

![207%20Course%20Schedule%202d44e0ff40004bd1be19127df0ba7995/Untitled.png](207%20Course%20Schedule%202d44e0ff40004bd1be19127df0ba7995/Untitled.png)

### Solution

- topological sort寻找cycle
    - 使用ArrayList数组代替Map创建graph
    - 可以使用一个int数组来表示visited和visiting两种状态

```java
class Solution {
    private boolean res = true;
    //time O(V + E) | space O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return true;
        
        //build graph
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i = 0; i < prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            //take c2 first; c2 -> c1
            graph[c2].add(c1);
        }
        //visiting 2; visited 1
        int[] visit = new int[numCourses];
        //dfs
        for(int i = 0; i < numCourses; i++){
            if(visit[i] != 1)
                dfs(graph, visit, i);
        }

        return res;
    }

    private void dfs(ArrayList<Integer>[] graph, int[] visit, int course){
        if(visit[course] == 2){
            res = false;
            return;
        }

        visit[course] = 2;
        for(int c : graph[course]){
            if(visit[c] != 1)
                dfs(graph, visit, c);
        }

        visit[course] = 1;
    }
}
```
