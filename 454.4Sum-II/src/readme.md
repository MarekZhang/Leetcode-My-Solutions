# 454. 4Sum II

![454%204Sum%20II%208d5e86a41178434dad4d7565403ba1d8/Untitled.png](454%204Sum%20II%208d5e86a41178434dad4d7565403ba1d8/Untitled.png)

### Solution

- 首先从数据规模N ≤ 500可推测出算法必须要是O(N^3)或者更好的性能，实测O(N^3)会超时。
- A,B,C,D中元素和的组合可拆分为A，B和的组合与C，D和的组合，这样就可用设计一个O(N^2)的算法

```java
public class Solution{
    //time complexity O(N^2) | space complexity O(N^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                map.putIfAbsent(sum, 0);
                map.put(sum, map.get(sum) + 1);
            }

        for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++){
                int tempt = C[i] + D[j];
                if(map.containsKey(-tempt))
                    result += map.get(-tempt);
            }

        return result;
    }
}
```

- 但是对于小数据规模的问题，HashMap的开销往往不能忽略，如果要避免使用HashMap，就可用将A,B和的组合生成新数组，C，D和的组合生成新数组，分别排序再使用two pointer去找结果

```java
class Solution {
		//time complexity O(N^2*log(N^2)) | space complexity O(N^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        int[] sum1 = new int[N * N];
        int idx = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                sum1[idx++] = A[i] + B[j];
        
        int[] sum2 = new int[N * N];
        idx = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                sum2[idx++] = -(C[i] + D[j]);
        
        Arrays.sort(sum1);
        Arrays.sort(sum2);

        int i, j, res;
        i = j = res = 0;
        int length1 = sum1.length;
        int length2 = sum2.length;
        while(i < length1 && j < length2) {
            if(sum1[i] < sum2[j]) i++;
            else if(sum1[i] > sum2[j]) j++;
            else{
                int count1 = 1; 
                int count2= 1;
                while(++i < length1 && sum1[i] == sum1[i-1]) count1++;
                while(++j < length2 && sum2[j] == sum2[j-1]) count2++;
                res += count1 * count2;
            }
        }

        return res;
    }
}
```