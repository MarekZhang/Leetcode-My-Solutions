/**
 * 102. Binary Tree Level Order Traversal
Medium

2884

73

Add to List

Share
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
import javafx.util.Pair;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;
        
        LinkedList<Pair<TreeNode, Integer>> linkedList = new LinkedList<>();
        linkedList.push(new Pair(root,0));
        while(!linkedList.isEmpty()){
            Pair<TreeNode,Integer> pair = linkedList.removeFirst();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if(level == list.size())
                list.add(new ArrayList<Integer>());
            
            list.get(level).add(node.val);
            if(node.left!=null)
                linkedList.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right!=null)
                linkedList.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
        }
        return list;
    }
}