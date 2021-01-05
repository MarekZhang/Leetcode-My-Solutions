# 815. Bus Routes

![815%20Bus%20Routes%20726d30a937a04e899040469803c4f435/Untitled.png](815%20Bus%20Routes%20726d30a937a04e899040469803c4f435/Untitled.png)

### Solution

- bfs, for each time when we remove a stop `**STOP**` from the queue, we would add those stops which are connected with `**STOP**` with the same bus, and we would never visit the same bus or stop twice.
- [huahua's blog](https://zxi.mytechroad.com/blog/searching/leetcode-815-bus-routes/)

    ![815%20Bus%20Routes%20726d30a937a04e899040469803c4f435/Untitled%201.png](815%20Bus%20Routes%20726d30a937a04e899040469803c4f435/Untitled%201.png)

```java
class Solution {
    //time complexity O(N * M) || space complexity O(M * N)
    public int numBusesToDestination(int[][] routes, int S, int T) {
        boolean[] buses = new boolean[routes.length];        
        //stop : bus list
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++){
                int stop = routes[i][j];
                graph.putIfAbsent(stop, new ArrayList<>());
                graph.get(stop).add(i);
            }
        }
        HashSet<Integer> stops = new HashSet<>();

        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{S, 0});
        //每次入队列当前stop所在bus的所有stop
        while(!queue.isEmpty()){
            int[] pair = queue.removeFirst();
            int s = pair[0];
            if(s == T) return pair[1];
            for(int bus : graph.get(s)){
                if(!buses[bus]){
                    buses[bus] = true;
                    for(int stop : routes[bus]){
                        if(!stops.contains(stop)){
                            stops.add(stop);
                            queue.addLast(new int[]{stop, pair[1] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
```