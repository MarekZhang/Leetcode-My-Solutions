## Solution
- [33. Search in Rotated Sorted Array](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/33.%20Search%20in%20Rotated%20Sorted%20Array/src) follow up
- 因为有重复元素，导致nums[nums[nums.lengt - 1]]可能与nums[0]相同，且有大量重复元素，这就导致mid可能落在first half arry 或者 second half array 且nums[mid] == nums[0]且无法判断是落在了哪半边
- 解决办法是，在right > left 的前提下 while(nums[right] == nums[left]) right --; 这样结尾元素与起始元素一定不同，进而可以使用leetcode 33的解题思路得到结果
- 重复元素对于复杂度的影响在于，如果数组中全部都是相同元素，时间复杂度会退化到O(N)

```java
class Solution {
    //worst case [1,1,1,1,1,1] time complexity O(1) || space complexity O(1)
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        
        int left = 0;
        int right = nums.length - 1;

        while(nums[right] == nums[0] && right > left)
            right --;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] >= nums[left]){
                if( target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }
}
```