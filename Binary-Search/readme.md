# Binary Search Template

- 此二分查找模板inspired by @labuladong [二分查找](https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E8%AF%A6%E8%A7%A3.md)，并对内容进行了精简

### 通用template

```java
public int binarySearch(int[] nums, int target){
	int left, right, mid;
	left = 0;
	right = ...;
	
	while(...){
		int mid = left + (right - left) / 2;
		if(arr[mid] < target){
			left = mid + 1;
		else if(arr[mid] > target)
			right = ...;
		else if(arr[mid] == target)
			mid = ...
	}
	
	return ...
}
```

- `left` `right` 初始化是在构建搜索区间(全闭区间或者左闭右开，取决于right的初始值）
- 更新`left` `right`边界相当于更新区间的范围，但是区间的闭开性不变(以新的区间作为传入参数nums调用函数)

### 查找一个target的index

- 以`right = nums.length - 1`为初始值，我们构建的区间[left, right]为比区间，所以终止条件为`left == right + 1` ;当left = right时，[left, right]仍存在一个元素需要判断

```c
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; // 注意

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; // 注意
        else if (nums[mid] > target)
            right = mid - 1; // 注意
    }
    return -1;
}
```

### 寻找左侧边界

- 构建闭区间`[left, right]`；由于while退出条件为`left == right + 1`, 且right取值范围为`[0, arr.length - 1]`, 则left的取值可能为`arr.length`, 左边界需要返回`left`，则需要对`left`是否等于`arr.length`进行判断

```c
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; 

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            right = mid - 1; 
        else if (nums[mid] < target)
            left = mid + 1; 
        else if (nums[mid] > target)
            right = mid - 1; 
    }
    if(left == arr.length || arr[left] != target) return -1;

		return left;
}
```

### 寻找右侧边界

- 构建比区间[left, right]; 由于while退出条件为`left == right + 1` ，且left的取值范围为`[0, arr.length-1]`,且需要返回right，right的取值可能为`-1` ，则需要对`right` 是否为-1进行判断

```c
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; 

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            left = mid + 1; 
        else if (nums[mid] < target)
            left = mid + 1; 
        else if (nums[mid] > target)
            right = mid - 1; 
    }
    if(right == -1 || arr[right] != target) return -1;

		return right;
}
```