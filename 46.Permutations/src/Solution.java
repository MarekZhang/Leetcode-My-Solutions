/**
 * 46. Permutations
Medium

3968

105

Add to List

Share
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0, list);

        return res;

    }

    private void dfs(int[] nums, int index, LinkedList<Integer> list) {
        if(index == nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                list.addLast(nums[i]);
                used[i] = true;
                dfs(nums,index+1,list);
                used[i] = false;
                list.removeLast();
            }
        }
    }
}