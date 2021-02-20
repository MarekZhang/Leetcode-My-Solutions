# 70. Climbing Stairs

![70%20Climbing%20Stairs%20cd1c92bbd57d49f7bfc40b5199d02bd7/Untitled.png](70%20Climbing%20Stairs%20cd1c92bbd57d49f7bfc40b5199d02bd7/Untitled.png)

### Solution

- memo[n] = memo[n - 1] + memo[n - 2]

```java
class Solution {
    // time complexity O(N) || space complexity O(N)
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i = 3; i <= n; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        
        return memo[n];
    }
}
```