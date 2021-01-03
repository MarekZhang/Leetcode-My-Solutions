# 526. Beautiful Arrangement

![526%20Beautiful%20Arrangement%206d2705a3cd0e4349839018f5848c3615/Untitled.png](526%20Beautiful%20Arrangement%206d2705a3cd0e4349839018f5848c3615/Untitled.png)

### Solution

- backtrack列举出所有的可能情况

```java
class Solution {
    private int res;
    //track back time complexity O(N!) || space complexiy O(N)
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];

        backtrack(visited, 1, n); 

        return res;
    }

    private void backtrack(boolean[] visited, int pos, int limit){
        if(pos > limit){
            res++;
            return;
        }

        for(int i = 1; i <= limit; i++){
            if(!visited[i]){
                int dividend = Integer.max(pos, i);
                int divisor = dividend == pos ? i : pos;
                if(dividend % divisor == 0){
                    visited[i] = true;
                    backtrack(visited, pos + 1, limit);
                    visited[i] = false;
                }
            }
        }
    }
}
```