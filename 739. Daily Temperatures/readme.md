# 739. Daily Temperatures

![739%20Daily%20Temperatures%20745723e0879d4b63b280f178ab3b30fc/Untitled.png](739%20Daily%20Temperatures%20745723e0879d4b63b280f178ab3b30fc/Untitled.png)

### Solution

- 构建单调递减栈，当遇到`T[i] > stack.peek()`时，进行出栈操作

```c
class Solution {
    //time complexity O(N) || space complexity O(N)
    public int[] dailyTemperatures(int[] T) {
       //monotonic stack
       Stack<Integer> stack = new Stack<Integer>();
       int[] res = new int[T.length];
       for(int i = 0; i < T.length; i++){
           if(stack.isEmpty() || T[i] <= T[stack.peek()])
               stack.push(i);
           else{
               while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                   int idx = stack.pop();
                   res[idx] = i - idx;
               } 
               stack.push(i);
           }
       }

       return res;
    }
}
```