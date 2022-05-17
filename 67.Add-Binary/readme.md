# 67. Add Binary

![Untitled](67%20Add%20Binary%208d0342127f2d4ca7b8c09446506e320f/Untitled.png)

- Usage of `StringBuilder`

```java
class Solution {
	//time complexit O(N) || space complexity O(N)
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        while(true) {
            int b1, b2;
            b1 = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            b2 = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            
            int sum = (b1 + b2 + carry);
            int digit =  sum % 2;
            carry = sum / 2;
            builder.append(digit);
            
            if(p1 < 0 && p2 < 0) break;
        }
        
        if(carry == 1) builder.append(1);
        builder.reverse();
        
        return builder.toString();
    }
}
```