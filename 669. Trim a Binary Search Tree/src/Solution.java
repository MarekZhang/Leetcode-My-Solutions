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
    //time complexity O(N) | space complexity O(H)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)return null;
        
        boolean lowBound = root.val < low; // out of range
        boolean highBound = root.val > high; // out of range
        if(lowBound) return trimBST(root.right, low, high);
        else if(highBound) return trimBST(root.left, low, high);
        else{ //in the range
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        
        return root;
    }
}