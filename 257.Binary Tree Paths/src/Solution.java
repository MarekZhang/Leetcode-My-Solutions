/**
 * 257. Binary Tree Paths
Easy

1690

106

Add to List

Share
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null)
            res.add(Integer.toString(root.val));
        
        List<String> leftRes = binaryTreePaths(root.left);
        for(int i = 0; i < leftRes.size(); i++)
            res.add(root.val + "->" + leftRes.get(i));
        
        List<String> rightRes = binaryTreePaths(root.right);
        for(int i = 0; i < rightRes.size(); i++)
            res.add(root.val + "->" + rightRes.get(i));

        return res;
    }
}