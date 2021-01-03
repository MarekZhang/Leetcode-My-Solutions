# 787. Cheapest Flights Within K Stops

![787%20Cheapest%20Flights%20Within%20K%20Stops%20fc7b8faa6ff84828af69aa07a8bf3b0d/Untitled.png](787%20Cheapest%20Flights%20Within%20K%20Stops%20fc7b8faa6ff84828af69aa07a8bf3b0d/Untitled.png)

![787%20Cheapest%20Flights%20Within%20K%20Stops%20fc7b8faa6ff84828af69aa07a8bf3b0d/Untitled%201.png](787%20Cheapest%20Flights%20Within%20K%20Stops%20fc7b8faa6ff84828af69aa07a8bf3b0d/Untitled%201.png)

### Solution 1

- 本题在找最短路径的基础上加上了number of path的限制。使用带有`boolean[] visited` 以及`int[] distTo` 从priority queue中取值并relax edges是不合适的，因为Dijkstra是以path sum最小为原则，而更小的path sum可能是更多的vertices 数量换来的。
- 所以如果要使用Dijkstra则需要记录path number; 从src开始，将与其相邻的vertices入priority queue。经过k+1个vertices的路径可能比经过k个vertices的路径更短，但是我们只关心在给定相同k的情况下，哪条路径更短

```java
class Solution {
		//time complexity O(ElogE) || space O(V+E); hashmap in Java takes more cost
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, price});
        }

        // int[]{a, b, c} a represent vertex; b represent price from src to a; c represent number of iteration
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        queue.offer(new int[]{src, 0, K + 1});
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int v = arr[0];
            int p = arr[1];
            int k = arr[2];
            if(k < 0) continue;
            //the first we pop dst from the queue, we get the chepest price with the given k limitation
            if(v == dst) return p;
            if(graph.containsKey(v)){
                for(int[] a : graph.get(v)){
                    int to = a[0];
                    int price = a[1];
                    queue.offer(new int[]{to, p + price, k- 1});
                }
            }
        }

        return -1;
    }
}
```

### Solution 2

- [**Bellman-Ford](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/Bellmand-Ford)** 的性质可以很好地应用在这道问题上：经历过第ith次全局relaxation，需要经过i个vertices的最短路径会被最终确定，在第i+1次全局relaxation不会再次更新
- 这里有一个问题需要注意，我们需要使用一个`**tempt**`数组来存储第ith全局relaxation的新路径，如果在原`**cost**`数组上更新会导致可能第i次的全局更新确定来需要经过i+1（i+2..)个vertices的最短路径会被最终确定, 这会导致我们得到的`cost[dst]`值不满足`K`的要求

```java
class Solution {
    //time complexity O(VE) || space complexity O(V)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //prevent overflow when adding inf with integer
        int infCost = 1 << 30;
        int[] cost = new int[n];
        Arrays.fill(cost, infCost);
        cost[src] = 0;

        for(int k = 0; k <= K; k++) {
            int[] tempt = Arrays.copyOfRange(cost, 0, n);
            for(int i = 0; i < flights.length; i++){
                int from = flights[i][0];
                int to = flights[i][1];
                int fare = flights[i][2];
                tempt[to] = Math.min(tempt[to], cost[from] + fare);
            }
            cost = tempt;
        }

        return cost[dst] == infCost ? -1 : cost[dst];
    }
}
```