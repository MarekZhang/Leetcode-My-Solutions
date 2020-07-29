/**
 * 417. Pacific Atlantic Water Flow
Medium

1295

263

Add to List

Share
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

class Solution {
    boolean[][] pacific, atlantic;
    int m,n;
    int[][] posOffset = {{1,0},{0,1},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        m = matrix.length;
        if(m == 0)
            return res;
        n = matrix[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        
        // matrix stored as {{1,3,2,6,5},{2,2,4,7,1}...}
        //top and bottom side
        for(int i = 0; i < m; i++){
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic,i, n-1);
        }
        //left and right side
        for(int i = 0; i < n; i++){
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, m-1, i);
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(atlantic[i][j]&&pacific[i][j])
                    res.add(Arrays.asList(new Integer[]{i, j}));
        
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y){
        visited[x][y] = true;

        for(int i = 0; i< 4; i++){
            int newX = x + posOffset[i][0];
            int newY = y + posOffset[i][1];
            if(inArea(newX, newY) && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y])
                dfs(matrix, visited, newX, newY);
        }
        
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}