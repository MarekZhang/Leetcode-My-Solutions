/**
 * 200. Number of Islands
Medium

5807

201

Add to List

Share
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

class Solution {
    private boolean[][] visited;
    private int m,n;
    private int[][] posOffset = {{1,0},{0,1},{-1,0},{0,-1}};
    private int res = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0)
            return 0;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    res++;
                    visited[i][j] = true;
                    floodfill(grid, i, j);
                }
            }

        return res;
    }

    private void floodfill(char[][] grid, int x, int y){
        
        for(int i = 0; i < 4; i++){
            int newX = x + posOffset[i][0];
            int newY = y + posOffset[i][1];
            if(inArea(newX, newY) && !visited[newX][newY] && char[newX][newY] == '1'){
                visited[newX][newY] = true;
                floodfill(grid, newX, newY);
            }
        }
        return;
    }

    private boolean inArea(int x, int y){
        return (x>=0 && x < m && y >= 0 && y < n);
    }
}