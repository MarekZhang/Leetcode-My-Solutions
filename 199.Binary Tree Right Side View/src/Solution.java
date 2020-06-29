/**
 * 199. Binary Tree Right Side View
Medium

2161

130

Add to List

Share
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        ArrayList<TreeNode> prevLayer = new ArrayList<>();
        prevLayer.add(root);
        while(!prevLayer.isEmpty()){
            res.add(prevLayer.get(prevLayer.size() - 1).val);
            ArrayList<TreeNode> curLayer = new ArrayList<>();
            for(int i = 0; i < prevLayer.size(); i++){
                TreeNode temptNode = prevLayer.get(i);
                if(temptNode.left!=null)
                    curLayer.add(temptNode.left);
                if(temptNode.right!=null)
                    curLayer.add(temptNode.right);
            }
            prevLayer = curLayer;
        }

        return res;
    }
}