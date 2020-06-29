/**
 * 107. Binary Tree Level Order Traversal II
Easy

1278

207

Add to List

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if(root == null)
            return list;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
          int size = queue.size();
          List<Integer> temptList = new ArrayList<>();

          for(int i = 0; i < size; i++){
            TreeNode node = queue.removeFirst();
            temptList.add(node.val);
            if(node.left != null)
              queue.add(node.left);
            if(node.right != null)
              queue.add(node.right);
          }
          list.addFirst(temptList);
        }
        
        return list;
    }
}