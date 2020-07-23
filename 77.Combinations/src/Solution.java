/**
 * 77. Combinations
Medium

1497

66

Add to List

Share
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(k > n)
            return res;

        LinkedList<Integer> list = new LinkedList<>();
        dfs(1, n, k, list);

        return res;
    }

    private void dfs(int startPoint, int n, int k, LinkedList<Integer> list) {
        if(k==0){ 
            res.add(new LinkedList<Integer>(list));
            return;
        }

        for(int i = startPoint; i <= n; i++){
            list.addLast(i);
            dfs(i + 1, n, k - 1, list);
            list.removeLast();
        }
    }
}