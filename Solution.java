class Solution {
    public double myPow(double x, int n) {
        if(n < 0) return 1.0 / myPow(x, -n);

        double res = 1.0;
        while(n != 0){
            if((n & 0x01) == 1) res *= x;
            x *= x;
        }

        return res;
    }
}