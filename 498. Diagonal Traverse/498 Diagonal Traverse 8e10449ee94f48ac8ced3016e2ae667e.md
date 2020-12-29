# 498. Diagonal Traverse

![498%20Diagonal%20Traverse%208e10449ee94f48ac8ced3016e2ae667e/Untitled.png](498%20Diagonal%20Traverse%208e10449ee94f48ac8ced3016e2ae667e/Untitled.png)

### Solution

- Consider the edge cases below:
    - when x == N or y == M where N equals to `matrix.length` and M equals to `matrix[0].length`
    - when x < 0 or y < 0
    - for each case, we need to turn around the iteration direction

```java
class Solution {
		//time complexity O(M * N) || space complexity O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        int N = matrix.length;
        if(matrix == null || N == 0) return new int[]{};
        
        int M = matrix[0].length;
        int x, y, idx, Dir;
        x = y = idx = 0;
        Dir = -1;
 
        int[] res = new int[N * M];

        while(x < N && y < M) {
            res[idx++] = matrix[x][y];
            x += Dir;
            y -= Dir;
            if(x == N){
                x -= 1;
                y += 2;
                Dir = - Dir;
            }else if (y == M){
                x += 2;
                y -= 1;
                Dir = - Dir;
            }else if(x == -1){
                x += 1;
                Dir = - Dir;
            }else if(y == -1){
                y += 1;
                Dir = - Dir;
            }
        }

        return res;
    }

}
```