/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode cur;
    //time O(N) || space O(H)
    public TreeNode increasingBST(TreeNode root) {
        cur = new TreeNode(-1);
        TreeNode res = cur;
        inorder(root);
        return res.right;
    }
    
    private void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = cur.right;
        inorder(node.right);   
    }
}