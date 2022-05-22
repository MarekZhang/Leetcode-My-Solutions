# 647. Palindromic Substrings

![Untitled](647%20Palindromic%20Substrings%20395a2bb1fe9848c69ed03d1082329276/Untitled.png)

- traverse the string, use index as the center of the palindrom

```java
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len == 0 || s == null) return 0;
        int count = 0;
        
        for(int i = 0; i < len; i++) {
            count += findPalindrom(i, i, s);
            count += findPalindrom(i, i + 1, s);
        }
        
        return count;
    }
    
    private int findPalindrom(int left, int right, String s) {
        int count = 0;
        int len = s.length();
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right) ) {
            left --;
            right ++;
            count ++;
        }
        
        return count;
    }
}
```