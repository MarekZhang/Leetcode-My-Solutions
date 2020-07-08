import javax.swing.text.DefaultStyledDocument.ElementSpec;

/**
 * 104. Maximum Depth of Binary Tree
Easy

2498

73

Add to List

Share
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int maxLeftTree = maxDepth(root.left);
        int maxrightTree = maxDepth(root.right);

        return Math.max(maxLeftTree, maxrightTree) + 1;
    }
}