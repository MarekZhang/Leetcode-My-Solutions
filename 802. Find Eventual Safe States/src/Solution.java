class Solution {
    private boolean[] visiting;
    private boolean[] visited;
    Map<Integer, List<Integer>> buildGraph = new HashMap<>();
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //build graph
        for(int i = 0; i < graph.length; i++){
            buildGraph.put(i, new ArrayList<>());
            for(int j = 0; j < graph[i].length; j++)
                buildGraph.get(i).add(graph[i][j]);
        }
        visiting = new boolean[graph.length];
        visited = new boolean[graph.length];
        //record vertexes reside in a cycle
        Set<Integer> set = new HashSet<>();
        //tempt list records dfs track
        LinkedList<Integer> dfsTrack = new LinkedList<>();
        
        for(int key : buildGraph.keySet()){
            dfsTrack.clear();
            if(hasDirectedCycle(key, dfsTrack, set))
                set.addAll(dfsTrack);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(!set.contains(i))
                res.add(i);
        }
        
        return res;
    }
    
    private boolean hasDirectedCycle(int vertex, LinkedList<Integer> dfsTrack, Set<Integer> set){
        if(visiting[vertex]) return true;
        if(set.contains(vertex)) return true;
        //vertex does not contains in set and has been visited
        if(visited[vertex]) return false;
        
        visiting[vertex] = true;
        dfsTrack.addLast(vertex);
        for(int vex : buildGraph.get(vertex)){
            if(hasDirectedCycle(vex, dfsTrack, set))
                return true;
        }
        dfsTrack.removeLast();
        visiting[vertex] = false;
        visited[vertex] = true;
        
        return false;  
    }
}