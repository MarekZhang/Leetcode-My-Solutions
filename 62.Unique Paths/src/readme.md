# 62. Unique Paths

![62%20Unique%20Paths%2042232ec7a70e4beabebba3089f2c11eb/Untitled.png](62%20Unique%20Paths%2042232ec7a70e4beabebba3089f2c11eb/Untitled.png)

### Solution

- For the first row and the first column, there is only 1 unique path to reach
- memo[i][j] = memo[i][j - 1] + memo[i - 1][j]
- we can optimize the space complexity to O(N)

```java
class Solution {
    // time complexity O(MN) || space complexity O(N)
    public int uniquePaths(int m, int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                memo[j] = memo[j] + memo[j - 1];
        }
        
        return memo[n - 1];
    }
}
```