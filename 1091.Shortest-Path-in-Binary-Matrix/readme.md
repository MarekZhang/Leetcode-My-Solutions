# 1091. Shortest Path in Binary Matrix

![Untitled](1091%20Shortest%20Path%20in%20Binary%20Matrix%209b4a8a1e14bf43618f48f8f5d16ee54f/Untitled.png)

![Untitled](1091%20Shortest%20Path%20in%20Binary%20Matrix%209b4a8a1e14bf43618f48f8f5d16ee54f/Untitled%201.png)

### Caveat

- why bfs?
    
    ![Untitled](1091%20Shortest%20Path%20in%20Binary%20Matrix%209b4a8a1e14bf43618f48f8f5d16ee54f/Untitled%202.png)
    
- `gird[0][0] == 0 && grid[n - 1][n - 1] == 0`

```java
class Solution {
    private int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        
        int res = 1;
        boolean[][] visited = new boolean[n][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] point = queue.removeFirst();
                int x = point[0];
                int y = point[1];
                if(grid[x][y] == 0 && x == (n - 1) && y == (n - 1)) return res;
                
                for(int[] arr : directions) {
                    int newX = x + arr[0];
                    int newY = y + arr[1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.addLast(new int[] {newX, newY});
                    }
                }
            }
            res++;
        }
        
        return -1;
    }
}
```