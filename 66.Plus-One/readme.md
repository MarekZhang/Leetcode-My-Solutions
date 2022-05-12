# 66. Plus One

![Untitled](66%20Plus%20One%2055d413f6ab37469c81a4aa20336b9c31/Untitled.png)

- consider bit overflow, arr length might be greater than 32/64
- only all 9s needs to grow the arr length for 1

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean carry = true;
        
        for(int i = len - 1; i >= 0; i --) {
            int val = 0;
            if(carry) val = 1;
            else return digits;
           
            int sum = val + digits[i];
            carry = sum > 9;
            digits[i] = sum % 10;
        }
        
        if(carry){
            int[] res = new int[len + 1];
            // only all 9s needs to grow the array
            res[0] = 1;
            return res;
        }
        
        return digits;
    }
}
```