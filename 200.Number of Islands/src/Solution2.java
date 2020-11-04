class Solution {
    //time complexity O(m * n) || space complexity O(m * n) -- worst case when grid[i][j] are all '1'
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(m == 0 || n == 0)
            return 0;
        int res = 0;
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}