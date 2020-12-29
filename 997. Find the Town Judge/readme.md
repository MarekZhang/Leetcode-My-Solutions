# 997. Find the Town Judge

![997%20Find%20the%20Town%20Judge%208a3ecb2098844f61951797b0ef7ba2f0/Untitled.png](997%20Find%20the%20Town%20Judge%208a3ecb2098844f61951797b0ef7ba2f0/Untitled.png)

### Solution

- find the vertex of which the in-degree equals to N-1 and out-degree equals to 0

```java
class Solution {
    //time O(N) || space O(N)
    public int findJudge(int N, int[][] trust) {
        int len = trust.length;    
        int res = -1;
        if(len == 0) return N > 1 ? -1 : 1;

        int[] indegree = new int[N + 1];
        int[] outdegree = new int[N + 1];
        for(int i = 0; i < len; i++){
            indegree[trust[i][1]]++;
            outdegree[trust[i][0]]++;
        }

        for(int i = 1; i <= N; i++)
            if(indegree[i] == N - 1 && outdegree[i] == 0)
                res = i;

        return res;
    }
}
```