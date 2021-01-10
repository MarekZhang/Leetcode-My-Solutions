# 56. Merge Intervals

![56%20Merge%20Intervals%2029253f95321c427aa90b080dcc71fe29/Untitled.png](56%20Merge%20Intervals%2029253f95321c427aa90b080dcc71fe29/Untitled.png)

### Solution

- we firstly need to sort the given intervals in natural order with comparing the first element in each array. This can be implemented by inserting arrays into a priority queue with customised comparator, or use `Arrays.sort()` with comparator
- we then use two pointers indicating the left and right boundaries of the integrated interval, when we traversing the intervals, if the left boundary of current array is greater than the right boundary of integrated interval, we need to create a new integrated interval and store the current integrated interval into our final result.

```java
class Solution {
    //time O(NlogN) || space O(N)
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        for(int[] arr : intervals) queue.offer(arr);

        int[] interval1 = queue.poll();
        int p1 = interval1[0], p2 = interval1[1];
        List<int[]> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int[] interval = queue.poll();
            if(interval[0] > p2){
                list.add(new int[]{p1, p2});
                p1 = interval[0];
                p2 = interval[1];
            }else if(interval[0] < p1)
                p1 = interval[0];
            else if(interval[1] > p2)
                p2 = interval[1];
        }
        list.add(new int[]{p1, p2});
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for(int[] arr : list) res[idx++] = arr;

        return res;
    }
}
```

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int p1 = intervals[0][0];
        int p2 = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        int N = intervals.length;
        for(int i = 1; i < N; i++){
            int[] interval = intervals[i];
            if(interval[0] > p2) {
                list.add(new int[]{p1, p2});
                p1 = interval[0];
                p2 = interval[1];
            }
            else if(interval[0] < p1) p1 = interval[0];
            else if(interval[1] > p2) p2 = interval[1];
        }

        list.add(new int[]{p1, p2});
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for(int[] arr : list) res[idx++] = arr;

        return res;
    }
}
```