# 1457. Pseudo-Palindromic Paths in a Binary Tree

![1457%20Pseudo-Palindromic%20Paths%20in%20a%20Binary%20Tree%205a3af5336fcf43aa9ae6710c776c513f/Untitled.png](1457%20Pseudo-Palindromic%20Paths%20in%20a%20Binary%20Tree%205a3af5336fcf43aa9ae6710c776c513f/Untitled.png)

![1457%20Pseudo-Palindromic%20Paths%20in%20a%20Binary%20Tree%205a3af5336fcf43aa9ae6710c776c513f/Untitled%201.png](1457%20Pseudo-Palindromic%20Paths%20in%20a%20Binary%20Tree%205a3af5336fcf43aa9ae6710c776c513f/Untitled%201.png)

### Solution

- we check the count of node values(0~9) when meet the root node.  If the number of odd value is greater than 1, we cannot formulate palindrome with the node value along the path.

```java
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
class Solution {
    private int res;
    //time complexity O(N) || space complexity O(1)    
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return res;     
        int[] count = new int[10];
        dfs(root, count);

        return res;
    }

    private void dfs(TreeNode node, int[] count){
        if(node.left == null && node.right == null){
            count[node.val]++;
            int c = 0;
            for(int num : count) if(num % 2 != 0) c++;
            if(c <= 1) res++;
            
            count[node.val]--;
            return;
        }
        count[node.val]++;
        if(node.left != null) dfs(node.left, count);
        if(node.right != null) dfs(node.right, count);
        count[node.val]--;
    }
}
```