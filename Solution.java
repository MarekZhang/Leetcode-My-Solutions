class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length - 1;
        //swap around the reverse diagonal
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i; j++)
                swap(matrix, i, j, N - j, N - i);
        }
        //swap around the middle row
        for(int i = 0; i < (N + 1) / 2; i++)
            for(int j = 0; j <= N; j++)
                swap(matrix, i, j, N - i, j);
    }

    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int tempt = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = tempt;
    }
}