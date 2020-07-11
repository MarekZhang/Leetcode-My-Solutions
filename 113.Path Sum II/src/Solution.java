/**
 * 113. Path Sum II
Medium

1752

64

Add to List

Share
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        List<Integer> dfsList = new ArrayList<>();
        dfs(res, dfsList, root, 0, sum);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> dfsList, TreeNode root, int tsum, int sum){

        tsum += root.val;
        dfsList.add(root.val);
        if(root.left == null && root.right == null){
            if(tsum == sum){
                //trap if add dfsList into res, the value in res will be changed when dfsList is changed
                res.add(new ArrayList<Integer>(dfsList));
            }
        }else{
            if(root.left != null)
                dfs(res, dfsList, root.left, tsum, sum);
            
            if(root.right != null)
                dfs(res, dfsList, root.right, tsum, sum);
        }
        dfsList.remove(dfsList.size() - 1);

        return;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        TreeNode left = root.left;
        TreeNode right = root.right;

        left.left = new TreeNode(11);
        right.left = new TreeNode(13);
        right.right = new TreeNode(4);

        TreeNode left2 = left.left;
        TreeNode right1 = right.right;

        left2.left = new TreeNode(7);
        left2.right = new TreeNode(2);

        right1.left = new TreeNode(5);
        right1.right = new TreeNode(1);

        new Solution().pathSum(root, 22);

    }
}