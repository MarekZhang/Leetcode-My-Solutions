/**
 * 110. Balanced Binary Tree
Easy

2231

167

Add to List

Share
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */

class Solution {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        maxDepth(root);
        
        return flag;
    }

    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if(!(Math.abs(leftDepth - rightDepth) <= 1))
            flag = false;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}