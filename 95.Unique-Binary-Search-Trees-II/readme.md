# 95. Unique Binary Search Trees II

![95%20Unique%20Binary%20Search%20Trees%20II%205236ba16097842c19ca3c26f0b744e49/Untitled.png](95%20Unique%20Binary%20Search%20Trees%20II%205236ba16097842c19ca3c26f0b744e49/Untitled.png)

### Solution

- it's a little bit difficult to solve this problem using backtrack. And life would be easier if we use a recursive function which return a list of all possible TreeNodes at the different layer of a tree. We use left and right boundary to determine how we would connect nodes to the left and right of current node.

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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right){
						// add null is essential,it works as a dummy node. 
						// We need to use if when traverse the list 
            res.add(null);
            return res;
        }
        for(int i = left; i <= right; i++){
            List<TreeNode> leftList = generate(left, i - 1);
            List<TreeNode> rightList = generate(i + 1, right);

            for(TreeNode leftNode : leftList){
                for(TreeNode rightNode : rightList){
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    res.add(cur);
                }
            }
        }

        return res;
    }
}
```