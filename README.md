# 1704. Determine if String Halves Are Alike

![1704%20Determine%20if%20String%20Halves%20Are%20Alike%206972c19f99e544018a5beff7205e67a6/Untitled.png](1704%20Determine%20if%20String%20Halves%20Are%20Alike%206972c19f99e544018a5beff7205e67a6/Untitled.png)

### Solution

- divide and count

```java
class Solution {
  // time complexity O(N) || space complexity O(1)
  public boolean halvesAreAlike(String s) {
    s = s.toLowerCase();
    int len = s.length();
    int count1, count2;
    count1 = count2 = 0;
    for (int i = 0; i < len / 2; i++)
      if (isVowel(s.charAt(i)))
        count1++;
    for (int i = len / 2; i < len; i++)
      if (isVowel(s.charAt(i)))
        count2++;

    return count1 == count2;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
```