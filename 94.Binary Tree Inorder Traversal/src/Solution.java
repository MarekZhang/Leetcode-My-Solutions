/**
 * 94. Binary Tree Inorder Traversal
Medium

3028

129

Add to List

Share
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    class Command{
        String s;
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }   

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<Command> stack = new Stack<>();

        stack.push(new Command("go", root));

        while(!stack.isEmpty()) {
            Command command = stack.pop();
            if(command.s.equals("print"))
                list.add(command.node.val);
            else{//程序入栈顺序和执行顺序是反的，入栈的是命令，入栈的是命令，入栈的是命令
                if(command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                stack.push(new Command("print", command.node));
                if(command.node.left!=null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return list;
    }

}