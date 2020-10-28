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
    private class TreeInfo{
        public final int height;
        public final boolean isBalanced;
        public TreeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
        
    }
    
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    
    private TreeInfo dfs(TreeNode root){
        if(root == null)
            return new TreeInfo(0, true);
        
        TreeInfo left = dfs(root.left);
        if(!left.isBalanced)
            return new TreeInfo(-1, false);
        
        TreeInfo right = dfs(root.right);
        if(!right.isBalanced)
            return new TreeInfo(-1, false);
        
        if(Math.abs(left.height - right.height) <= 1)
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        
        return new TreeInfo(-1, false);
    }
}