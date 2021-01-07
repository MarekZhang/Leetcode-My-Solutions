# 34. Find First and Last Position of Element in Sorted Array

![34%20Find%20First%20and%20Last%20Position%20of%20Element%20in%20Sort%20ffafb8d4f1f341e1be81fe2889882e8d/Untitled.png](34%20Find%20First%20and%20Last%20Position%20of%20Element%20in%20Sort%20ffafb8d4f1f341e1be81fe2889882e8d/Untitled.png)

- find the left boundary of the index of  target: [binary search template](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/Binary-Search)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] >=  target) right = mid - 1;
            else left = mid + 1; 
        }
        if(left == nums.length || nums[left] != target) return new int[]{-1, -1}; 
        int pos = left;
        while(pos < nums.length && nums[pos] == nums[left]) pos++;

        return new int[]{left, pos - 1};
    }
}
```