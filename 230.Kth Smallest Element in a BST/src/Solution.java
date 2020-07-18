/**
 * 230. Kth Smallest Element in a BST
Medium

2592

63

Add to List

Share
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int nodes = numOfNodes(root.left);
        if(nodes == k)
            return findMax(root.left).val;
        else if(nodes > k)
            return kthSmallest(root.left, k);
        else if(nodes + 1 == k)
            return root.val;
        // k > nodes + 1
        return kthSmallest(root.right, k - nodes - 1);
    }

    private int numOfNodes(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        
        return numOfNodes(root.left) + numOfNodes(root.right) + 1;
    }

    private TreeNode findMax(TreeNode root){
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;

        return findMax(root.right);
    }
}