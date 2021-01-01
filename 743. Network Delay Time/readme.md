# 743. Network Delay Time

![743%20Network%20Delay%20Time%2068ab20ccb9c041268e4b6727b356308e/Untitled.png](743%20Network%20Delay%20Time%2068ab20ccb9c041268e4b6727b356308e/Untitled.png)

### Solution

- Dijkstra求最短路径问题：
    - `DistTo[i]`存储起始`vertex`到`i` 的最短距离，初始值为Integer.MAX_VALUE
    - `visited[i]` 存储vertex i是否已经进行了relaxation(起始vertex到i的距离已经是最短了，注:Dijkstra的前提是第一次relax vertex i，得到的DistTo[i]的结果就是最短的，**这需要edge weight 为正数**, Dijkstra可以处理graph中存在cycle的情况)
    - `PriorityQueue` 存储起始结点到`vertex v`的距离, 如果`!visite[v]` 则此次取出`v` 就意味着当前情况即为起始结点到`v`最短的路径
    - 使用`Map<Integer, ArrayList<int[]>>` 构建directed weight graph, 减少`Map<Integer, Map<Integer, Integer>>`构建加权有向图的开销
    - **[讲解Dijkstra最好的视频](https://www.youtube.com/watch?v=2E7MmKv0Y24&index=16&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)**

    ```java
    class Solution {
        int[] distTo;
        boolean[] visited;
        PriorityQueue<Pair<Integer, Integer>> queue;
        //Dijkstra time complexity O(E*logE) || space complexity O(V + E)
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
            for(int i = 0; i < times.length; i++) {
                int from = times[i][0];
                int to = times[i][1];
                int delay = times[i][2];
                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from).add(new int[]{to, delay});
            }

            //node labelled from 1 to N
            distTo = new int[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[K] = 0;
            //pair(vertex, dist from K to vertex)
            queue = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
            queue.offer(new Pair<Integer, Integer>(K, 0));
            while(!queue.isEmpty()){
                Pair<Integer, Integer> pair = queue.poll();
                int vertex = pair.getKey();
                int dist = pair.getValue();
                if(visited[vertex]) continue;
                if(graph.containsKey(vertex)) relax(vertex, graph);
                visited[vertex] = true;
            }

            int res = -1;
            for(int i = 1; i <= N; i++){
                if(distTo[i] == Integer.MAX_VALUE) return -1;
                res = Integer.max(res, distTo[i]);
            }

            return res;
        }

        private void relax(int from, Map<Integer, ArrayList<int[]>> graph){

            for(int[] pair : graph.get(from)){
                int to = pair[0];
                int weight = pair[1];
                int distance = distTo[from] + weight;
                if(distance < distTo[to]){
                    distTo[to] = distance;
                    queue.offer(new Pair<Integer, Integer>(to, distance));
                }
            }
        }
    }
    ```