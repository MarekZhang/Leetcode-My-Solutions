# 78. Subsets

![78%20Subsets%209d9d731a491a439a937753de1746b53e/Untitled.png](78%20Subsets%209d9d731a491a439a937753de1746b53e/Untitled.png)

### Solution

- each element in the given array can either be in the subset or not. So we have $2^n$  different subsets
- the first solution is using back track,  when `start == len` we need to add tempt to res
- the second solution is using BFS

```java
class Solution{
  // backtrack time complexity O(N) || space complexity O(N)
  public List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new LinkedList<>());

    return res;
  }

  private void backtrack(int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> tempt){
    int len = nums.length;
		//if(start > len) return;
    res.add(new ArrayList<>(tempt));

    for(int i = start; i < len; i++){
      tempt.addLast(nums[i]);
      backtrack(i + 1, nums, res, tempt);
      tempt.removeLast();
    }
  }
}
```

```java
class Solution{
  // BFS time complexity O(N) || space complexity O(1)
  public List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    int len = nums.length, i = 0;
    while(i < len){
      int sz = res.size();
      for(int j = 0; j < sz; j++){
        List<Integer> list = res.get(j);
        // copy original list;
        res.add(new ArrayList<>(list));
        list.add(nums[i]);
      }

      i++;
    }

    return res;
  }
}
```