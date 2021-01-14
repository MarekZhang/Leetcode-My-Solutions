# 1658. Minimum Operations to Reduce X to Zero

![1658%20Minimum%20Operations%20to%20Reduce%20X%20to%20Zero%20a659c2be8cfd48f38c054e45f44f9ed0/Untitled.png](1658%20Minimum%20Operations%20to%20Reduce%20X%20to%20Zero%20a659c2be8cfd48f38c054e45f44f9ed0/Untitled.png)

### Solution

- it is not simply comparing the leftmost element with the rightmost element and subtract the bigger one from x, we need to find a left sub range and a right sub range with which, the sum of those elements equals to x and the number of elements is smallest.

    ![1658%20Minimum%20Operations%20to%20Reduce%20X%20to%20Zero%20a659c2be8cfd48f38c054e45f44f9ed0/Untitled%201.png](1658%20Minimum%20Operations%20to%20Reduce%20X%20to%20Zero%20a659c2be8cfd48f38c054e45f44f9ed0/Untitled%201.png)

- we firstly only use the left side elements to build a map of which the key is the number of left elements and the value is the sum of those elements. We then start to iterate from right side and try to find the complement part `x - rightSum` from the map we built(is very similar to the solution of Two sum).

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        int sum = 0, N = nums.length;
        
        for(int i = 0; i < N - 1 && sum < x; i++){
            //need add sum == 0 to the map, the operations can be all in right side
            left.put(sum, i);
            sum += nums[i];
        }

        int res = Integer.MAX_VALUE;
        sum = 0;
        //find the complement part in the right side
        for(int i = N - 1; i >= 0 && sum <= x; i--){
            //need consider complement == x, the operations can be all in left side
            int complement = x - sum;
            if(left.containsKey(complement)){
                int operations = left.get(complement) + N - 1 - i;
                res = res < operations ? res : operations; 
            }
            sum += nums[i];
        }

        return res ==  Integer.MAX_VALUE ? -1 : res;
    }

}
```