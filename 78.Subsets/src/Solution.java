/**
 * 78. Subsets
Medium

3941

85

Add to List

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length=0)
            return res;
        LinkedList<Integer> tempt = new LinkedList<>();
        findSubsets(nums, 0, tempt);

        return res;
    }

    private void findSubsets(int[] nums, int index, LinkedList<Integer> tempt) {
        res.add(tempt);

        for(int i = index; i < nums.length; i++){
            tempt.addLast(nums[i]);
            findSubsets(nums, i + 1, capacity + 1, tempt);
            tempt.removeLast();
        }

        return;
    }
}