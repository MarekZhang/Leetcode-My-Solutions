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
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        findMaxPath(root);
        
        return res;
    }

    private int findMaxPath(TreeNode root){
        if(root == null)
            return 0;
        //calculate left and right node path value
        int leftVal = Math.max(findMaxPath(root.left), 0);
        int rightVal = Math.max(findMaxPath(root.right), 0);

        //sum we would get if we take current node as the highest node in the path
        int temptSum = root.val + leftVal + rightVal;
        res = res > temptSum ? res : temptSum;

        //return the result if current node is on the path
        return root.val + Math.max(leftVal, rightVal);
    }
}