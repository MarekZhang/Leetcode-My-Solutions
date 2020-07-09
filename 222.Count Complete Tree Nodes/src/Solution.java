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
import java.util.*;

class Solution {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int count = 1;
        while(!list.isEmpty()){
            TreeNode temptNode = list.removeFirst();
            count++;
            if(temptNode.left != null)
                list.addLast(temptNode.left);
            if(temptNode.right != null)
                list.addLast(temptNode.right);
        }

        return count;
    }
}