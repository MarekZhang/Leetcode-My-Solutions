class Solution {
    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;
    
    //time complexity O(E + V) | space complexity O(V) // worst case graph is connected
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        marked = new boolean[V];
        color = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!marked[i]){
                dfs(graph, i);
            } 
        }
        
        return isBipartite;
    }
    
    private void dfs(int[][] graph, int vertex){
        marked[vertex] = true;
        int[] adj = graph[vertex];
        for(int w : adj){
            if(!marked[w]){
                color[w] = !color[vertex];
                dfs(graph, w);
            }else if(color[w] == color[vertex])
                isBipartite = false;
        }
    }
}