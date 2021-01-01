# 503. Next Greater Element II

![503%20Next%20Greater%20Element%20II%204491674443d84401b0b57eb5758d1800/Untitled.png](503%20Next%20Greater%20Element%20II%204491674443d84401b0b57eb5758d1800/Untitled.png)

### Solution

- 将input array拼接在其最后一个元素后面，遍历这个length * 2的数组
- 使用单调递减栈存储数组的index，当 `aux[i] > aux[stack.peek()]` 将pop出的数组index对应的位置更新为当前aux[i]的值，直到stack中的index对应的数组中的值都大于aux[i]，将i入栈

```java
class Solution {
    //time complexity O(N) || space complexity O(N)
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] aux = new int[N * 2];
        for(int i = 0; i < N; i++) aux[i] = aux[i + N] = nums[i];

        for(int i = 0; i < aux.length; i++){
            if(stack.isEmpty() || aux[i] <= aux[stack.peek()])
                stack.push(i);
            else{
                while(!stack.isEmpty() && aux[i] > aux[stack.peek()]){
                    int idx = stack.pop();
                    if(idx < N) nums[idx] = aux[i];
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            if(idx < N) nums[idx] = -1;
        }

        return nums;
    }
}
```