class KnapSack2{
    //dynamic programming time O(n*c) || space O(n*c);
    public int knapSack(int[] v, int[] w, int capacity) {
      assert(v.length == w.length);
      int n = v.length;
      if(n == 0 || capacity <= 0)
        return 0;
  
      int[][] memo = new int[n][capacity + 1];
  
      for(int c = 0; c <= capacity; c++)
        if(c >= w[0])
          memo[0][c] = v[0];
  
      for(int i = 1; i < n; i++)
        for(int c = 1; c <= capacity; c++){
          int res = memo[i - 1][c];
          if(c >= w[i])
            memo[i][c] = Math.max(res, memo[i - 1][c - w[i]] + v[i]);
        }
  
      return memo[n-1][capacity];
    }
  }