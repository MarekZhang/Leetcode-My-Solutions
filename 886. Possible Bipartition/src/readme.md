# 886. Possible Bipartition

![886%20Possible%20Bipartition%204862a1faacc24261907c83e2b5a77708/Untitled.png](886%20Possible%20Bipartition%204862a1faacc24261907c83e2b5a77708/Untitled.png)

### Solution

- 本质上需要我们将相互dislike的vertex连接起来建立一个graph，然后用dfs来判断这个graph能不能构成一个bipartitie
- 虽然看起来不难，但有几个需要注意的细节：
    1. dislike[i][0]和dislike[i][1]是双向的，如果按照单向建立连接会有bug 如下图：本来通过一次dfs就可以遍历所有的vertex，但由于是单向的，就导致调用dfs两次，而如果恰巧3已经遍历完了，当前4的color又是false就会得到不正确的结果

        ![886%20Possible%20Bipartition%204862a1faacc24261907c83e2b5a77708/IMG_1A78B5D9CD96-1.jpeg](886%20Possible%20Bipartition%204862a1faacc24261907c83e2b5a77708/IMG_1A78B5D9CD96-1.jpeg)

    2. vertex的index是[1, N],数组需要多一位
    3. 可以使用Map建立graph，但通常Java维护Map的开销很大，所以这里可以用ArrayList数组
    4. Java中不能new 泛型数组，正确写法：`ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N + 1];`

```java
class Solution {
    private boolean res = true;
		//time complexity O(E+V) | space complexity O(E + V)
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int n = dislikes.length;
        if(n == 0) return true;        
        //build graph
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>(); 

        for(int i = 0; i < n; i++){
            int p1 = dislikes[i][0];
            int p2 = dislikes[i][1];
            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        boolean[] visited = new boolean[N + 1];
        boolean[] color = new boolean[N + 1];
        //dfs
        for(int i = 1; i <= N; i++){
            for(int p : graph[i]){
                if(!visited[p])
                    dfs(graph, p, visited, color);
            }
        }
        
        return res;
    }

    private void dfs(ArrayList<Integer>[] graph, int p, boolean[] visited, boolean[] color) {
        visited[p] = true;

        if(graph[p].size() != 0){
            for(int val : graph[p]){
                if(!visited[val]){
                    color[val] = !color[p];
                    dfs(graph, val, visited, color);
                }
                else if(color[val] == color[p])
                    res = false;
            }
        }
    }
}
```