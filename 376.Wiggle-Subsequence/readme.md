# 376. Wiggle Subsequence

![376%20Wiggle%20Subsequence%20eb40b740e27c42e8afcb149c1b937913/Untitled.png](376%20Wiggle%20Subsequence%20eb40b740e27c42e8afcb149c1b937913/Untitled.png)

### Solution

- greedy algorithm; we first assess whether the sequence is in increasing order or decrasing order
    - if in increasing order, we keep retriving elements until nums[i] < nums[i - 1]
    - if in decreasing order, we keep retriving elements until nums[i] > nums[i - 1]

![376%20Wiggle%20Subsequence%20eb40b740e27c42e8afcb149c1b937913/Untitled%201.png](376%20Wiggle%20Subsequence%20eb40b740e27c42e8afcb149c1b937913/Untitled%201.png)

```java
class Solution {
  // greedy algorithm time complexity O(N) || space complexity O(1)
  public int wiggleMaxLength(int[] nums) {
    int len = nums.length;
    int res = 1;
    if(len == 1) return 1;
    // using flag to indicate whether we need a bigger value or smaller value
    // true represents
    int i = 1;
    boolean flag = true;

    // find the first not equal position
    while(i < len){
      if(nums[i] != nums[i - 1]){
        flag = nums[i] - nums[i - 1] > 0;
        res++;
        break;
      }else{
        i++;
      }
    }

    for(; i < len; i ++){
      if(flag){ // sequence in increasing direction | skip the condition when nums[i] == max
        if(nums[i] < nums[i - 1]){
          res++;
          flag = false;
        }
      }else{ // sequence in decreasing direction | skip the condition when nums[i] == min
        if(nums[i] > nums[i - 1]){
          res++;
          flag = true;
        }
      }
    }

    return res;
  }
}
```

```java
class Solution {
  // greedy algorithm more elegant
  public int wiggleMaxLength(int[] nums) {
    int len = nums.length;
    int gt, lt;
    gt = lt = 1;
    if(len == 1) return 1;

    for(int i = 1; i < len; i++){
      if(nums[i] > nums[i - 1]){
        gt = lt + 1;
      }else if(nums[i] < nums[i - 1]){
        lt = gt + 1;
      }
    }

    return Integer.min(len, Integer.max(gt, lt));
  }
}
```