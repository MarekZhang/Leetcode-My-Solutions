/**
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

1960

99

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.*;
import javafx.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<Pair<TreeNode, Integer>> pair = new LinkedList<>();
        pair.add(new Pair<TreeNode, Integer>(root,0));

        while(!pair.isEmpty()){
            Pair<TreeNode,Integer> tempt = pair.removeFirst();
            TreeNode temptNode = tempt.getKey();
            Integer temptValue = tempt.getValue();
            if(temptValue==list.size()){
                 list.add(new ArrayList<Integer>());
            }
            list.get(temptValue).add(temptNode.val);
            if(temptNode.left!=null)
                pair.add(new Pair<TreeNode,Integer>(temptNode.left, temptValue + 1));
            if(temptNode.right!=null)
                pair.add(new Pair<TreeNode,Integer>(temptNode.right, temptValue + 1));
        }
        for(int i=1; i < list.size(); i+=2){
            Collections.reverse(list.get(i));
        }

        return list;
    }

}