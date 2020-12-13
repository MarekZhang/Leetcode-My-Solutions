class Solution {
    //time complexity O(N ^ 3) | space O(N)
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int padding[] = new int[N + 2];
        padding[0] = 1;
        padding[N + 1] = 1;
        for(int i = 1; i <= N; i++)
            padding[i] = nums[i - 1];
        int res[][] = new int[N + 2][N + 2];

        for(int l = 1; l <= N; l++){
            for(int i = 1; i <= N - l + 1; i++){
                int j = i + l - 1; 
                for(int k = i; k <= j; k++){
                    res[i][j] = Integer.max(res[i][j], res[i][k - 1] + 
                                    padding[i - 1] * padding[k] * padding[j + 1] 
                                    + res[k + 1][j]);
                }
            }
        }

        return res[1][N];
    }
}