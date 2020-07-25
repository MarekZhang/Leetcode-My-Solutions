/**
 * 216. Combination Sum III
Medium

1061

51

Add to List

Share
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
  
    public List<List<Integer>> combinationSum3(int k, int n) {
      if(n < k)
        return res;
  
      LinkedList<Integer> tempt = new LinkedList<Integer>();
      dfs(1, k, n, tempt);
  
      return res;
    }
  
    private void dfs(int startPoint, int k, int n, LinkedList<Integer> tempt){
      if(tempt.size() == k){
        if(n == sumOfList(tempt))
          res.add(new LinkedList<Integer>(tempt));
        return;
      }
  
      for(int i = startPoint; i <= 9 - k - (k - tempt.size()) + 1; i++){
        tempt.addLast(i);
        dfs(i + 1, k , n, tempt);
        tempt.removeLast();
      }
  
      return;
    }
  
    private int sumOfList(LinkedList<Integer> list){
      int sum = 0;
      for(Integer e: list)
        sum+=e;
      return sum;
    }
  
    public static void main(String[] args) {
      List<List<Integer>> list = new Solution().combinationSum3(3, 7);
      System.out.println(list);
    }
  }