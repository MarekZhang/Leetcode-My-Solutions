class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m == 0 || n == 0)
            return 0;

        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m ; i++)
            memo[i][n] = 0;

        for(int i = 0; i <=n; i++)
            memo[m][i] = 0;

        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--){
                if(text2.charAt(i) == text1.charAt(j))
                    memo[j][i] = memo[j+1][i+1] + 1;
                else
                    memo[j][i] = Math.max(memo[j+1][i], memo[j][i+1]);
            }

        return memo[0][0];
    }

}