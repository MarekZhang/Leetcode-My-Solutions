# 869. Reordered Power of 2

![869%20Reordered%20Power%20of%202%202dcca053241d473793a1c6709eacc213/Untitled.png](869%20Reordered%20Power%20of%202%202dcca053241d473793a1c6709eacc213/Untitled.png)

### Solution

- covert integer value to string; order and compare

```java
class Solution {
  // time complexity O(NlogN) || space complexity O(N)
  public boolean reorderedPowerOf2(int N) {
    char[] ch = String.valueOf(N).toCharArray();
    Arrays.sort(ch);
    String s = new String(ch);

    for(int i = 0; i < 32; i++){
      String tempt = String.valueOf(1 << i);
      char[] temptCh = tempt.toCharArray();
      Arrays.sort(temptCh);
      tempt = new String(temptCh);
      if(s.equals(tempt)) return true;
    }

    return false;
  }
}
```