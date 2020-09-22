//optimize the space complexity from O(n*m) to O(m) where m is the capacity of the KnapSack

class KnapSack3{

    public int knapSack(int[] v, int[] w, int capacity){
        assert(v.length == w.length);
        int n = v.length;
        if(n == 0 || capacity <= 0)
            return 0;

        int[] memo = new int[capacity + 1];

        for(int c = 0; c <= capacity; c++)
            memo[c] = w[0] <= c ? v[0] : 0;

        
        for(int i = 1; i < n; i++)
            for(int c = capacity; c >= w[i]; c--){//always get 0 when capacity is 0; when capacity is less than w[i] there's no need to update
                if(c >= w[i]){
                    memo[c] = Math.max(memo[c], memo[c - w[i]] + v[i]);
                }
            }

        return memo[capacity];
    }
}