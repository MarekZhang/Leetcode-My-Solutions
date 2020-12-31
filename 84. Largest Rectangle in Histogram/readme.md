# 84. Largest Rectangle in Histogram

![84%20Largest%20Rectangle%20in%20Histogram%2083fbfb0f3d9a44eeb970784a1a2c9310/Untitled.png](84%20Largest%20Rectangle%20in%20Histogram%2083fbfb0f3d9a44eeb970784a1a2c9310/Untitled.png)

- [**Monotonic Stack 单调栈**](https://blog.csdn.net/lucky52529/article/details/89155694)
    - 单调递增栈: 栈底→栈顶元素大小递增
    - 单调递减栈: 栈底→栈顶元素大小递减
    - Pseudo code

        ```c
        stack<int> st;
        //此处一般需要给数组最后添加结束标志符，具体下面例题会有详细讲解
        for (遍历这个数组)
        {
        	if (栈空 || 栈顶元素大于等于当前比较元素)
        	{
        		入栈;
        	}
        	else
        	{
        		while (栈不为空 && 栈顶元素小于当前元素)
        		{
        			栈顶元素出栈;
        			更新结果;
        		}
        		当前数据入栈;
        	}
        }
        ```

### Solution

- 使用monotonic stack, 且栈为单调递增栈, 这样当遇到了小于栈顶的元素时(`index==i`)，对栈中元素依次出栈，pop()出的值(`index==k`)即为当前区间内`[k,i)`最小的rectangle. 面积和为`(i - k) * height[k]`
- 上述操作对最终结果进行更新，同时我们也要对height数组进行改动，以求得以当前更小的rectangle面积为基准，更大区间的面积和

    ```c
    height[idx] = height[i];// the left bound of the smaller bar
    stack.push(idx);
    ```

    如下图，当遍历到height[i] == 1之后会将左边界(rectangle == 2)更新为height[i]的值；当遍历到height[i] == 3之后会将左边界(rectangle == 5)更新为height[i]的值(rectangle == 1 < 3, 不会出栈)

    ![84%20Largest%20Rectangle%20in%20Histogram%2083fbfb0f3d9a44eeb970784a1a2c9310/IMG_B1878BC52995-1.jpeg](84%20Largest%20Rectangle%20in%20Histogram%2083fbfb0f3d9a44eeb970784a1a2c9310/IMG_B1878BC52995-1.jpeg)

- 在原数组结尾添加-1以便能够取出所有面积大小(最小为1)

    ```java
    class Solution {
        //monotonic stack || time O(N) || space O(N)
        public int largestRectangleArea(int[] heights) {
            int N = heights.length;
            if(N == 0) return 0;
            int[] height = new int[N + 1];
            height[N] = -1; //in order to pop the smallest height
            for(int i = 0; i < N; i++) height[i] = heights[i];
            
            int res, idx = 0;
            Stack<Integer> stack = new Stack<Integer>();
            res = -1;        
            for(int i = 0; i <= N; i++){
                if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                    stack.push(i);
                }else{
                    while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                        idx = stack.pop();
                        res = Integer.max(res, (i - idx) * height[idx]);
                    }
                    height[idx] = height[i];// the left bound of the smaller bar
                    stack.push(idx);
                }
            }

            return res;
        }
    }
    ```