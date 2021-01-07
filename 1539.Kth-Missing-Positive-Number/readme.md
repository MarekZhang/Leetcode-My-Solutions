# 1539. Kth Missing Positive Number

![1539%20Kth%20Missing%20Positive%20Number%20ec23a435b3744e619a85007000cded92/Untitled.png](1539%20Kth%20Missing%20Positive%20Number%20ec23a435b3744e619a85007000cded92/Untitled.png)

### Solution

- 根据`arr[i]`的index以及`arr[i]`的值即可推导出当前元素之前有多少个missing元素`arr[i] - i - 1`

    ![1539%20Kth%20Missing%20Positive%20Number%20ec23a435b3744e619a85007000cded92/IMG_1228E87C3BBC-1.jpeg](1539%20Kth%20Missing%20Positive%20Number%20ec23a435b3744e619a85007000cded92/IMG_1228E87C3BBC-1.jpeg)

- 我们需要找到missing元素个数 ≥ k的**左边界(e.g. k == 6, 对于数组[2,3,4,7,11,12,13]我们需要找到元素11的位置)**
- 使用二分查找法寻找左边界，如果`arr.length - 1` 位置的元素仍无法满足要求，left会落在arr.length的位置(recall 寻找左边界终止条件为left == right + 1, 且right取值上限为`arr.length  - 1`)
- 而我们要求得的missing 元素的值为`left + k` （left落在的位置表示在当前元素前面已经有left个元素了）

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] - mid - 1 >= k)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left + k;
    }
}
```