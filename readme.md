# 329. Longest Increasing Path in a Matrix

![329%20Longest%20Increasing%20Path%20in%20a%20Matrix%204dcd0f5ef5dc42598b4d572403fbe31d/Untitled.png](329%20Longest%20Increasing%20Path%20in%20a%20Matrix%204dcd0f5ef5dc42598b4d572403fbe31d/Untitled.png)

### Solution

- [Longest Path in DAG](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/288520/Longest-Path-in-DAG)

```java
class Solution {
  int rows, cols;
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;
    rows = matrix.length;
    cols = matrix[0].length;
    int[][] dir = new int[][]{{1,0}, {0, 1}, {-1,0}, {0,-1}};
    LinkedList<int[]> queue = new LinkedList<>();
    int res = 0;

    int[][] outdegree = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        for (int k = 0; k < dir.length; k++) {
          int newX = i + dir[k][0];
          int newY = j + dir[k][1];
          if (inBound(newX, newY) && matrix[newX][newY] > matrix[i][j])
            outdegree[i][j]++;
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (outdegree[i][j] == 0) // add the destination to the queue
          queue.addLast(new int[]{i, j});
      }
    }

    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        int[] cords = queue.removeFirst();
        int x = cords[0];
        int y = cords[1];
        for (int j = 0; j < dir.length; j++) {
          int newX = x + dir[j][0];
          int newY = y + dir[j][1];
          if (inBound(newX, newY) &&matrix[newX][newY] < matrix[x][y] && --outdegree[newX][newY] == 0)
            queue.addLast(new int[]{newX, newY});
        }
      }
      res++;
    }

    return res;
  }

  private boolean inBound (int x, int y) {
    return x >= 0 && x < rows && y >= 0 && y < cols;
  }
}
```
