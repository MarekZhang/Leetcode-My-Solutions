# 941. Valid Mountain Array

![941%20Valid%20Mountain%20Array%2013216c8612284f5c8d3598ed9a719f30/Screenshot_2020-12-10_at_19.24.08.png](941%20Valid%20Mountain%20Array%2013216c8612284f5c8d3598ed9a719f30/Screenshot_2020-12-10_at_19.24.08.png)

### Solution

- consider the edge case of lower and upper boundary

```java
class Solution {
		//time complexity O(N) | space complexity O(1)
    public boolean validMountainArray(int[] arr) {
        int N = arr.length;
        if(N < 3) return false;
        int i, j;
        i = 0;
        j = N - 1;
        while(arr[i+1] > arr[i]){
            i++;
            if(i == N - 1) return false;
        }
        while(arr[j - 1] > arr[j]){
            j--;
            if(j == 0) return false;
        }
        return i==j;
    }
}
```