# 1162. As Far from Land as Possible

![1162%20As%20Far%20from%20Land%20as%20Possible%2064cd7dd7665345debcbbef23a1d5011b/Untitled.png](1162%20As%20Far%20from%20Land%20as%20Possible%2064cd7dd7665345debcbbef23a1d5011b/Untitled.png)

### Solution

- 最开始想用dfs解是错误的，当前的0 vertex可能会在其它0 vertex中绕几次才到达vertex 1。其实如果加上额外的限制条件也是能解出来的，但是dfs要比bfs占用的空间更大，跑起来也更慢
- 使用bfs，从land (vertex 1)开始遍历,更新与之相邻的四个vertices，并将这些vertices enqueue.

    ![1162%20As%20Far%20from%20Land%20as%20Possible%2064cd7dd7665345debcbbef23a1d5011b/IMG_8C03F3AFF8D0-1.jpeg](1162%20As%20Far%20from%20Land%20as%20Possible%2064cd7dd7665345debcbbef23a1d5011b/IMG_8C03F3AFF8D0-1.jpeg)

    ```java
    class Solution {
        private int m, n;
        //time complexity O(N^2) | space complexity O(N^2)
        public int maxDistance(int[][] grid) {
            int[][] offset = {{1,0},{0,1},{-1,0},{0,-1}};       
            LinkedList<int[]> queue = new LinkedList<>();
            m = grid.length;
            n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int size = 0;
            //enqueue all land vertex
            for(int i = 0; i < m; i++) 
                for(int j = 0; j < n; j++)
                    if(grid[i][j] == 1){
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});
                        size++;
                    }
            int res = -1;
            //bfs
            while(!queue.isEmpty()){
                int newSize = 0;
                while(size-- != 0){
                    int[] pair = queue.poll();
                    for(int i = 0; i < offset.length; i++){
                        int x = pair[0] + offset[i][0];
                        int y = pair[1] + offset[i][1];
                        if(inBoard(x, y) && !visited[x][y]){
                            newSize++;
                            visited[x][y] = true;
                            int dist = grid[pair[0]][pair[1]];
                            grid[x][y] = dist + 1;
                            res = Integer.max(res, dist + 1);
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
                size = newSize;
            }

            return res == -1 ? -1 : res - 1;
        }

        private boolean inBoard(int x, int y){ return x >=0 && x < m && y >= 0 && y < n; }

    }
    ```