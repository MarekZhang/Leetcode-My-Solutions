# 1337. The K Weakest Rows in a Matrix

![1337%20The%20K%20Weakest%20Rows%20in%20a%20Matrix%20c61b995cc904405281ed53791e112dc7/Untitled.png](1337%20The%20K%20Weakest%20Rows%20in%20a%20Matrix%20c61b995cc904405281ed53791e112dc7/Untitled.png)

### Solution

- Binary Search + PriorityQueue
- we store the number of 1s and the row number  in a new array and add the arrray into a priority queue
- [binary search template](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/Binary-Search)

```java

class Solution {
  // time complexity O(m*logn) || space complexity O(m*n)
  public int[] kWeakestRows(int[][] mat, int k) {
    // arr[0] represents the number of ones; arr[1] represents the row number
    PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[0] != arr2[0] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);
    int m = mat.length;
    for(int i = 0; i < m; i++){
      queue.offer(new int[]{howManyOnes(mat[i]) ,i});
    }

    int[] res = new int[k];
    int idx = 0;
    while(idx < k){
      res[idx++] = queue.poll()[1];
    }

    return res;
  }

  private int howManyOnes(int[] arr) {
    //find the right boundary of one;
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int tempt = arr[mid];
      if (tempt == 1) {
        left = mid + 1;
      } else if (tempt == 0) {
        right = mid - 1;
      }
    }
    
    // if zero 1 element, right == -1
    return right;
  }

}
```
