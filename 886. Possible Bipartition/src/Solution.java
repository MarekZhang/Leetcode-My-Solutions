class Solution {
    //time complexity O(V + E) | space complexity O(V + E)
    boolean[] marked;
    boolean[] color;
    private boolean isBipartite = true;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //build graph, space complexity O(V + E), if directed 
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < dislikes.length; i++){
            int v = dislikes[i][0];
            int w = dislikes[i][1];
            graph[v].add(w);
            graph[w].add(v);
        }
        
        marked = new boolean[N + 1];
        color = new boolean[N + 1];
        for(int v = 1; v <= N; v++){
            if(!marked[v])
                dfs(graph, v);
        }
        
        return isBipartite;
    }
    
    private void dfs(ArrayList<Integer>[] graph, int vertex){
        marked[vertex] = true;
        for(int w : graph[vertex]){
            if(!marked[w]){
                color[w] = !color[vertex];
                dfs(graph, w);           
            }
            else if(color[w] == color[vertex])
                isBipartite = false;
        }
    } 
}