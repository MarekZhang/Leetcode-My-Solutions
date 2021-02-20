# 796. Rotate String

![796%20Rotate%20String%203d4da2d12b934052b019b521e797e4b4/Untitled.png](796%20Rotate%20String%203d4da2d12b934052b019b521e797e4b4/Untitled.png)

### Solution

- if we concat two String A together, if B is rotated by A, then we can find A contains B.
- A: "ababcde"  B"abcdeab"

```java
class Solution {
		// time complexity O(N)
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        A = A + A;
        return A.indexOf(B) != -1;
    }
}
```