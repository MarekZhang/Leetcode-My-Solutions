class Solution {
    public int[] decode(int[] encoded) {
        int N = encoded.length + 1;
        int[] res = new int[N];
        // mask1 = a0^a1^a2...an-1 = 1^2^3^...N
        int mask1 = 0, mask2 = 0;
        for(int i = 1; i <= N ;i++) mask ^= i;

        // mask2 = a1^a2...an-1
        for(int i = 1; i < N - 2; i+=2)
            mask2 ^= encoded[i];
        res[0] = mask1 ^ mask2;

        for(int i = 1; i < N; i++)
            res[i] = encoded[i - 1] ^ res[i - 1];
        
    }
}