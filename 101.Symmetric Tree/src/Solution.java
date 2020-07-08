/**
 * 101. Symmetric Tree
Easy

4106

97

Add to List

Share
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if(n1==null && n2==null)
            return true;
        if(n1==null && n2!=null || n1!=null && n2==null)
            return false;
        if(n1.val != n2.val)
            return false;

        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
}