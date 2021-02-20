# 443. String Compression

![443%20String%20Compression%20fa0b3af497db49fe95a3b97ae9badc79/Untitled.png](443%20String%20Compression%20fa0b3af497db49fe95a3b97ae9badc79/Untitled.png)

### Solution

- this problem is similar to the CTCI [Chapter 1 Arrays and String 1.6]
- we use two pointers and StringBuilder to compress string

```java
class Solution{
  public int compress(char[] chars){
    int p1 = 0, p2 = 0;
    int len = chars.length;
    StringBuilder builder = new StringBuilder();

    while(p1 < len){
      p2 = p1 + 1;
      while(p2 < len && chars[p2] == chars[p1]) p2++;
      int num = p2 - p1;
      builder.append(chars[p1]);
      if(num > 1) builder.append(num);
      p1 = p2;
    }

    char[] tempt = builder.toString().toCharArray();
    int res = tempt.length;
    for(int i = 0; i < res; i++)
      chars[i] = tempt[i];

    return res;
  }
  // test cases:
  // 1. "a"
  // 2. "aaabbccc"
  // 3. "aaabbc"
}
```