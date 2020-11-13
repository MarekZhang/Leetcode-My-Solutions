class Solution {
    boolean[] visited;
    int[] distTo;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //build graph
        for(int i = 0; i < times.length; i++){
            int[] edge = times[i];
            int u = edge[0], v = edge[1], weight = edge[2];
            graph.computeIfAbsent(u, (map) -> new HashMap<>());
            graph.get(u).put(v, weight);
        }
        
        visited = new boolean[N + 1];
        distTo = new int[N + 1];
        //int[] a, a[0] represents the vertex, a[1]represents the weight 
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        //Dijkstra algo
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[K] = 0;
        queue.offer(new int[]{K, 0});
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int w = pair[0];
            int weight =pair[1];
            if(visited[w]) continue; // w has already been in the shortest path
            visited[w] = true;
            relax(graph, queue, w);
        }
        
        //traverse the shortest path from K to each node
        int res = -1;
        for(int i = 1; i <= N; i++){
            if(i == K) continue;
            else if(distTo[i] == Integer.MAX_VALUE) return -1;//there's an unreachable vertex
            else if(distTo[i] > res) res = distTo[i];
        }
        
        return res;
    }
    
    private void relax(Map<Integer, Map<Integer, Integer>> graph, PriorityQueue<int[]> queue, int vertex){
        if(graph.get(vertex) != null){
            for(int w : graph.get(vertex).keySet()){
                int pathWeight = distTo[vertex] + graph.get(vertex).get(w);
                if(distTo[w] > pathWeight){
                    distTo[w] = pathWeight;
                    queue.offer(new int[]{w, pathWeight});
                }   
            }
        }
    }
}