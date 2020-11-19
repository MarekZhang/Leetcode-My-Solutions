class Solution {
    private int N;
    private int M;
    private boolean[][] visited;
    private int count;
    private int offset[][] = {{1, 0}, {0, 1}, {-1, 0}, {0 , -1}};
    public int maxAreaOfIsland(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        visited = new boolean[M][N];
        if(N == 0)
            return 0;
        int maxArea = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    dfs(i, j, grid);
                    maxArea = maxArea > count ? maxArea : count;
                }
            }     
        }
        
        return maxArea;
    }
    
    private void dfs(int x, int y, int[][] grid){
        count++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + offset[i][0];
            int newY = y + offset[i][1];
            if(inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1)
                dfs(newX, newY, grid);
        }
    }
    
    private boolean inArea(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}