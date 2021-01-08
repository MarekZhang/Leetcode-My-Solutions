# 50. Pow(x, n)

![50%20Pow(x,%20n)%205d3f25a9f3934e4c89bd591d74718325/Untitled.png](50%20Pow(x,%20n)%205d3f25a9f3934e4c89bd591d74718325/Untitled.png)

### Solution

- the most intuitive solution is multiply the result with x in a for loop, but unfortunately there would be time limit error when n equals 2^31 - 1（this requires more than 2 billion iteration）， so we need to find an algorithm with the `logN` time complexity
- the first acceptable solution is a recursive one, `if n % 2 == 0` return myPow(x*x, n / 2), otherwise we return myPow(x *x , (n - 1) / 2) * x
- a smarter solution would transfer the exponent into binary format

    ![50%20Pow(x,%20n)%205d3f25a9f3934e4c89bd591d74718325/IMG_5DB65ACF0988-1.jpeg](50%20Pow(x,%20n)%205d3f25a9f3934e4c89bd591d74718325/IMG_5DB65ACF0988-1.jpeg)

- one tricky edge case we should notice is x = -2^31, if we want to return 1 / myPow(x, -n) this would lead to time limit error, as for integer the bit level of -2^31 = -(-2^31)

```c
double myPow(double x, int n){
    //in case of n == -2^31
    if(n < 0) return 1.0 / (myPow(x, -(n + 1)) * x);
    double res = 1.0;
    while(n){
        if(n & 0x01) res *= x;
        x *= x;
        n >>= 1;
    }
    
    return res;
}
```

```c
double myPow(double x, int n){
    if(n < 0) return 1 / (myPow(x, -(n+1)) * x);
    if(n == 0) return 1.0;
    
    if(n % 2 == 1) return myPow(x * x, (n - 1) / 2) * x;
    else return myPow(x * x, n / 2);
}
```
