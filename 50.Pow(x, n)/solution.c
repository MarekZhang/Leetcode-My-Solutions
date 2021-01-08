double myPow(double x, int n){
    if(n < 0) return 1.0 / (myPow(x, -(n + 1)) * x);
    double res = 1.0;
    while(n){
        if(n & 0x01) res *= x;
        x *= x;
        n >>= 1;
    }
    
    return res;
}
