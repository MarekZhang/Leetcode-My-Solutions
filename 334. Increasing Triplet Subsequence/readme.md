# 334. Increasing Triplet Subsequence

![334%20Increasing%20Triplet%20Subsequence%2057c44f9293184c0183269e1147f041d2/Screenshot_2020-12-18_at_17.11.13.png](334%20Increasing%20Triplet%20Subsequence%2057c44f9293184c0183269e1147f041d2/Screenshot_2020-12-18_at_17.11.13.png)

### Solution

- maintain two lower boundaries `first`  and `second`.
- whenever we encounter an element which is smaller than `first` or `second` we would update the value.
- update `first`  is reasonable as there's guarantee that an element smaller than `second` exists in the array. And update `first` is essential for finding smaller two boundaries

```java
class Solution {
		//time complexity O(N) | space complexity O(1)
    public boolean increasingTriplet(int[] nums) {
        int first, second;
        first = second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= first) first = num;
            else if(num <= second) second = num;
            else return true;
        }
        
        return false;
    }
}
```