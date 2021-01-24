# 1734. Decode XORed Permutation

![1734%20Decode%20XORed%20Permutation%2071c01a196102427792a1641cf3450e59/Untitled.png](1734%20Decode%20XORed%20Permutation%2071c01a196102427792a1641cf3450e59/Untitled.png)

### Solution

- for the encoded array, encoded = [a0^a1, a1^a2, a2^a3...., an-2 ^ an-1]. We can create a bit mask: mask1= a1^a2^a3...^an-1 by XOR elements in encoded array with odd index. And we also know that **the perm array is a permutation of the first n positive integers, then mask2 = a0 ^ a1 ^ a2....an-1 = 1 ^ 2 ^3 ... ^n**
- a0 = mask1 ^ mask2; the remaining part can be solved

```java
class Solution {
    public int[] decode(int[] encoded) {
        int N = encoded.length + 1;
        int[] res = new int[N];
        // mask1 = a0^a1^a2...an-1 = 1^2^3^...N
        int mask1 = 0, mask2 = 0;
        for(int i = 1; i <= N ;i++) mask1 ^= i;

        // mask2 = a1^a2...an-1
        for(int i = 1; i < N - 1; i+=2)
            mask2 ^= encoded[i];
        res[0] = mask1 ^ mask2;

        for(int i = 1; i < N; i++)
            res[i] = encoded[i - 1] ^ res[i - 1];

        return res;
    }
}
```