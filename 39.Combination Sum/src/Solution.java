/**
 * 39. Combination Sum
Add to List

Share
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
Each element of candidate is unique.
1 <= target <= 500s
 */

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for( int i = index; i < nums.length; i++){
            list.addLast(nums[i]);
            dfs(nums, i, target - nums[i], list);
            list.removeLast();
        }
    }
}