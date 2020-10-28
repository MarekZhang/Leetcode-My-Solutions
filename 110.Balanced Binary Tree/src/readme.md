## Leetcode 110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Input: root = [3,9,20,null,null,15,7]
Output: true

### Solution
- 第一种解法借助求Tree的深度Top-Bottom从而比较左右节点深度是否相差超过1来确定是否为Balanced Binary Tree
- 由于对于每一个节点都要进行高度的计算，导致算法时间复杂度为O(NlogN)
```java
class Solution {
    //time complexity O(n * log(n)) || space complexity O(1)
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;
                
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root){
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
```

- 第二种解法Bottom-Top，使用DFS，从leaf开始向上遍历，比较左右subtree的高度
```java
class Solution {
    private class TreeInfo{
        public final int height;
        public final boolean isBalanced;
        public TreeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
        
    }
    
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    
    private TreeInfo dfs(TreeNode root){
        if(root == null)
            return new TreeInfo(0, true);
        
        TreeInfo left = dfs(root.left);
        if(!left.isBalanced)
            return new TreeInfo(-1, false);
        
        TreeInfo right = dfs(root.right);
        if(!right.isBalanced)
            return new TreeInfo(-1, false);
        
        if(Math.abs(left.height - right.height) <= 1)
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        
        return new TreeInfo(-1, false);
    }
}
```
