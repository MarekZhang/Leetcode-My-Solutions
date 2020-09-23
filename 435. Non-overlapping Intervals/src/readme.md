# 435. Non-overlapping Intervals

### Solution 1 (dp)

1.排序
comparator 的几种写法
```java
//lambda
Arrays.sort(intervals, (o1, o2)) -> o1[0] - o2[0]);
```
```java
Arrays.sort(intervals, new Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
});
```

```java
Arrays.sort(intervals, new IntervalComparator());

class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a1, int[] a2){
        return a1[0] - a2[0];
    }
}
```

2.与求LIS一样的dp方法

### Solution2
Greedy Algorithm

## Follow Up

[300. Longest Increasing Subsequence](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/300.%20Longest%20Increasing%20Subsequence/src)
