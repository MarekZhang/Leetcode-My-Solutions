# 496. Next Greater Element I

![496%20Next%20Greater%20Element%20I%206d1224c457d84dc0adcc972a8b16619b/Untitled.png](496%20Next%20Greater%20Element%20I%206d1224c457d84dc0adcc972a8b16619b/Untitled.png)

### Solution

- 使用单调递减栈，当遇到nums2[i] > stack.peek()的时候元素出栈
- note 2: `nums1 nums2 length ≤ 1000`是错误的，测试用例中有数组大小为4000+

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();       
        int[] map = new int[10000];
        for(int i = 0; i < nums2.length; i++){
            if(stack.isEmpty() || nums2[i] <= stack.peek())
                stack.push(nums2[i]);
            else{
                while(!stack.isEmpty() && nums2[i] > stack.peek())
                    map[stack.pop()] = nums2[i];
                stack.push(nums2[i]);
            }
        }
        while(!stack.isEmpty()) map[stack.pop()] = -1;

        for(int i = 0; i < nums1.length; i++)
            nums1[i] = map[nums1[i]];
        
        return nums1;
    }
}
```