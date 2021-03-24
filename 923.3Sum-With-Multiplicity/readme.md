# 923. 3Sum With Multiplicity

![923%203Sum%20With%20Multiplicity%20d9fc76dabaf44cd9813846e97d7e072c/Untitled.png](923%203Sum%20With%20Multiplicity%20d9fc76dabaf44cd9813846e97d7e072c/Untitled.png)

### Solution

- a trivial O(N^3) solution

```java
class Solution {
  public int threeSumMulti(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = arr.length;
    int res = 0;
    int modulo = (int)1e9 + 7;
    for(int i = 0; i < len; i++){
      res += map.getOrDefault(target - arr[i], 0);
      for(int j = 0; j < i; j++){
        int tempt = arr[i] + arr[j];
        map.put(tempt, map.getOrDefault(tempt, 0) +1);
      }
    }

    return res % modulo;
  }
}
```