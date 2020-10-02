class Solution {
    //dp time complexity O(n) | space complexity O(1)
    public int[] countBits(int num) {
        //res[i] represents the popcount(hamming weight) of i
        int res = new int[num + 1];
        for(int i = 1; i <= num; i++) 
            res[i] = res[i&(i-1)] + 1;

        return res;
    }
}