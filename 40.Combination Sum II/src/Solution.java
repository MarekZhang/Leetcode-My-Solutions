/**
 * 40. Combination Sum II
Medium

1789

67

Add to List

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return res;
        LinkedList<Integer> tempt = new LinkedList<>();

        dfs(candidates, 0, target, tempt);

        return res;
    }

    private void dfs(int[] nums, int index, int target, LinkedList<Integer> list){
        if(target < 0)
            return;
        if(target == 0){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        Arrays.sort(nums);
        
        Set<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                list.addLast(nums[i]);
                dfs(nums, i + 1, target - nums[i], list);
                list.removeLast();
            }
        }
    }
}