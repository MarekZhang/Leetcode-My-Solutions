# Array

Created: Dec 6, 2020 10:51 PM

### Leetcode 59. Spiral Matrix II

![Array%20442b61787c094568b7fa213e0790b388/Screenshot_2020-12-07_at_13.30.57.png](Array%20442b61787c094568b7fa213e0790b388/Screenshot_2020-12-07_at_13.30.57.png)

```java
class Solution {
    //time complexity O(N^2) | space complexity O(1)
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int elementsCount = n;
        int val = 1;
        while(elementsCount > 0){
            int N = matrix.length;
            int start = (N - elementsCount) / 2;
            int end = N - start - 1;
            //fill in four edges
            for(int i = start; i <= end; i++)
                matrix[start][i] = val++;
            for(int i = start + 1; i <= end; i++)
                matrix[i][end] = val++;
            for(int i = end - 1; i >= start; i--)
                matrix[end][i] = val++;
            for(int i = end - 1; i > start; i--)
                matrix[i][start] = val++;
            
            elementsCount-=2;
        }
        
        
        return matrix;
    }
}
```