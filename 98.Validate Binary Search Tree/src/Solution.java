/**
 * 98. Validate Binary Search Tree
Medium

3916

536

Add to List

Share
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        inOrder(root);
        for(int i = 0; i < list.size() - 1; i++)
            if(list.get(i) >= list.get(i + 1))
                return false;

        return true;
    }

    private void inOrder(TreeNode root) {
        if(root.left != null)
            inOrder(root.left);
        list.add(root.val);
        if(root.right != null)
            inOrder(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        TreeNode rightNode = root.right;
        rightNode.left = new TreeNode(6);
        rightNode.right = new TreeNode(20);

        boolean res = new Solution().isValidBST(root);

        System.out.println(res);
    }
}