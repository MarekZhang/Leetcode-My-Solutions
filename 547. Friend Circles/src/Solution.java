class Solution {
    private boolean visited[];
    
    public int findCircleNum(int[][] M) {
        int N = M.length;
        visited = new boolean[N];
        int count = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                dfs(M, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, int student){
        visited[student] = true;
        for(int i = 0; i < M.length; i++){
            if(!visited[i] && M[student][i] == 1)
                dfs(M, i);
        }
    }
}