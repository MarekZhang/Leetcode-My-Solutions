/**
 * 47. Permutations II
Medium

1958

61

Add to List

Share
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0)
            return res;

        LinkedList<Integer> tempt = new LinkedList<>();
        used = new boolean[nums.length];
        dfs(nums, 0, tempt);

        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> list){
        if(index == nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        boolean[] sameDigit = new boolean[10];
        for(int i = 0; i < nums.length; i++){
            if(!used[i] && !sameDigit[i]){
                sameDigit[nums[i]] == true;
                used[i] = true;
                list.addLast(nums[i]);
                dfs(nums, index + 1, list);
                used[i] = false;
                list.removeLast();
            }
        }
    }
}