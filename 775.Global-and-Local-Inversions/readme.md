# 775. Global and Local Inversions

![775%20Global%20and%20Local%20Inversions%208aa5db1eeda44af683bc38742b009515/Untitled.png](775%20Global%20and%20Local%20Inversions%208aa5db1eeda44af683bc38742b009515/Untitled.png)

### Solution

- local inversions are all global inversions, but global inversion may not be a local inversion
- if there is a global inversion which is not a local inversion, the result must be false
- as $A[i]\in[0...N-1]$ if $abs(A[i] - 1) > 1$ the final result would be false

![775%20Global%20and%20Local%20Inversions%208aa5db1eeda44af683bc38742b009515/IMG_6CA5497A1669-1.jpeg](775%20Global%20and%20Local%20Inversions%208aa5db1eeda44af683bc38742b009515/IMG_6CA5497A1669-1.jpeg)

```java
class Solution {
  // time complexity O(N) | space complexity O(1)
  public boolean isIdealPermutation(int[] A) {
    int len = A.length;
    for(int i = 0; i < len; i++) {
      if(Math.abs(A[i] - i) > 1)
        return false;
    }

    return true;
  }
}
```