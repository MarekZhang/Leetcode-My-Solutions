# 485. Max Consecutive Ones

![485%20Max%20Consecutive%20Ones%20b4fb47fcc0e04c60abc5a45651f0a450/Untitled.png](485%20Max%20Consecutive%20Ones%20b4fb47fcc0e04c60abc5a45651f0a450/Untitled.png)

### Solution

- two pointers

```java
class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int res = 0, len = nums.length;
    int pos1 = 0;

    while(pos1 < len){
      if(nums[pos1] == 1){
        int pos2 = pos1 + 1;
        while(pos2 < len && nums[pos2] == 1) pos2 ++;
        res = Integer.max(res, pos2 - pos1);
        pos1 = pos2 + 1;
      }else{
        pos1++;
      }
    }

    return res;
  }
}
```