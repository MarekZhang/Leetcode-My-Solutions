class Solution {
    //   ' a d c e
    // ' 0 0 0 0 0
    // a 0 1 1 1 1
    // c 0 1 1 2 1
    // time complexity O(M * N) || space O(M * N)
    public int longestCommonSubsequence(String text1, String text2) {
        int N1 = text1.length();
        int N2 = text2.length();
        if(N1 == 0 || N2 == 0)
            return 0;
        
        int[][] memo = new int[N1 + 1][N2 + 1];
        for(int i = 1; i <= N1; i++)
            for(int j = 1; j <= N2; j++){
               if(text1.charAt(i - 1) == text2.charAt(j - 1))
                   memo[i][j] = memo[i - 1][j - 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
                
        return memo[N1][N2];
    }
}