/**
 * 108. Convert Sorted Array to Binary Search Tree
Easy

2454

213

Add to List

Share
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
import java.util.Arrays;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return null;
        int mid = len / 2;

        TreeNode root = new TreeNode(nums[mid]);
        int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, len);

        root.left = sortedArrayToBST(leftArr);
        root.right = sortedArrayToBST(rightArr);

        return root;
    }
}