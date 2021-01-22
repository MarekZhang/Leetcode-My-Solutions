# 1673. Find the Most Competitive Subsequence

![1673%20Find%20the%20Most%20Competitive%20Subsequence%2031dae7e8d48442eaa0732f878bc8e4ec/Untitled.png](1673%20Find%20the%20Most%20Competitive%20Subsequence%2031dae7e8d48442eaa0732f878bc8e4ec/Untitled.png)

### Solution

- we can solve this problem with constructing a monotonic stack - we keep elements in the ascending order
- if the current element is smaller than the peek of the stack, we keep pop values off the stack, but if the remaining number of elements in the array is equal  to `(k - stack.size())` we simply pop element in without comparing

```java
class Solution {
  // time complexity O(N) || space O(N)
  public int[] mostCompetitive(int[] nums, int k) {
    Stack<Integer> stack = new Stack<>();
    int N = nums.length;
    for(int i = 0; i < N; i++){
      int tempt = nums[i];
      if(stack.isEmpty() || tempt >= stack.peek()){
        stack.push(tempt);
      }else{
        int rem = N - i;
        int stackSize = k - stack.size();
        // current value is less than the top element and the number of remaining element in the array is sufficient to fill the stack
        while(!stack.isEmpty() && tempt < stack.peek() && rem > stackSize){
          stack.pop();
          stackSize = k - stack.size();
        }
        stack.push(tempt);
      }
    }

    while(stack.size() > k) stack.pop();

    int[] res = new int[k];
    for(int i = k - 1; i >= 0; i--) res[i] = stack.pop();

    return res;
  }
}
```