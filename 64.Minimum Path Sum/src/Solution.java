/**
 * 64. Minimum Path Sum
Medium

3172

63

Add to List

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

class Solution {
    //posOffset left and top
    private int[][] posOffset = {{0, -1}, {-1, 0}};
    int m, n;
  
    public int minPathSum(int[][] grid) {
      if(grid.length == 0)
        return 0;
      m = grid.length;
      n = grid[0].length;
  
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          grid[i][j] += minimumSum(grid, i, j);
        }
      }
  
      return grid[m-1][n-1];
    }
  
    private int minimumSum(int[][] grid, int i, int j){
      if(i == 0 && j == 0)
        return 0;
  
      int newXL = i + posOffset[0][0];
      int newYL = j + posOffset[0][1];
      int newXT = i + posOffset[1][0];
      int newYT = j + posOffset[1][1];
      if(inArea(newXL, newYL) && inArea(newXT, newYT))
        return Math.min(grid[newXL][newYL], grid[newXT][newYT]);
  
      if(!inArea(newXL, newYL))
        return grid[newXT][newYT];
  
      if(!inArea(newXT, newYT))
        return grid[newXL][newYL];
  
      return 0;
    }
  
    private boolean inArea(int i, int j){
      return i >= 0 && i < m && j >= 0 && j < n;
    }
  
    public static void main(String[] args) {
      int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
      System.out.println(new Solution().minPathSum(arr));
    }
  }