# 1010. Pairs of Songs With Total Durations Divisible by 60

### LeetCode 1010. Pairs of Songs With Total Durations Divisible by 60

![1010%20Pairs%20of%20Songs%20With%20Total%20Durations%20Divisible%20f7672552a9044003bf4327b64fb97c3b/Screenshot_2020-12-08_at_21.46.01.png](1010%20Pairs%20of%20Songs%20With%20Total%20Durations%20Divisible%20f7672552a9044003bf4327b64fb97c3b/Screenshot_2020-12-08_at_21.46.01.png)

### Solution

- 最开始我的思路是将array中的数转换成$arr[i] = arr[i]  \% 60$ ,然后排序再用two pointers来计算组合的总数量。但是这并不能将余数为0和余数为30的两种特殊情况包含进去，当arr[i] == arr[i-1]还需要将j指针回移动，很麻烦且容易出错
- 正确的解答方法应该是使用一个hashmap(这里用一个length == 60的余数数组就可以了)来计算数组中元素%60得到的结果在[0，59]，每一种余数结果的总数量。然后将0和30两种edge case单独考虑，其它情况就是remCount[i] * remCount[60 - i]的结果加到res上就可以了

```java
class Solution {
    //time O(N) || space O(60) ~ O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int N = time.length;
        int remCount[] = new int[60];
        //remainder val in the range of [0, 59];
        int res = 0;
        for(int i = 0; i < N; i++)
            remCount[time[i] % 60]++;
        for(int i = 1; i < 30; i++)
            res += (remCount[i] * remCount[60 - i]);
        //remainder value equals to 0 and 30 are special cases
        res += (remCount[0] * (remCount[0] - 1) / 2);
        res += (remCount[30] * (remCount[30] - 1) / 2);
        
        return res;
    }
}
```