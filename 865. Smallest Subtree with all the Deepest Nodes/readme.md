# 865. Smallest Subtree with all the Deepest Nodes

![865%20Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes%206aedfa1e68cd445d9e3187d1b8d232e2/Screenshot_2020-12-12_at_18.44.07.png](865%20Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes%206aedfa1e68cd445d9e3187d1b8d232e2/Screenshot_2020-12-12_at_18.44.07.png)

![865%20Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes%206aedfa1e68cd445d9e3187d1b8d232e2/Screenshot_2020-12-12_at_18.44.24.png](865%20Smallest%20Subtree%20with%20all%20the%20Deepest%20Nodes%206aedfa1e68cd445d9e3187d1b8d232e2/Screenshot_2020-12-12_at_18.44.24.png)

### Solution

- 题意解释过来就是要找到所有deepest nodes的lowest common ancestor(LCA [LeetCode 236.Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | [Solution](https://github.com/MarekZhang/Leetcode-My-Solutions/blob/master/236.Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree/src/Solution.java))
- 三次dfs可以解决这个问题。第一次计算树中最大深度，第二次计算树中deepest nodes的个数，第三次按照求LCA的方式，每找到一个deepest node，count++，当count第一次达到deepest node个数的时候，当前结点就是我们要找的结点。
- 要注意的问题是，deepest node本身就是自己的LCA，例如测试用例3，node2是deepest node，且这个树中只有一个deepest node，返回的结果是node2，而不是它的parent node3

```java
class Solution {
    private int count;
    private int depth;
    private TreeNode res;    
    //time complexity O(N) | space complexity O(H) stack space
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = maxDepth(root); 
        dfs(root, 1);
        LCA(root, 1);
        
        return res;
    }
    
    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        return Integer.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private void dfs(TreeNode node, int level){
        if(node == null) return;
        if(level == depth){
            count++;
            return;
        } 
        dfs(node.left ,level + 1);
        dfs(node.right, level + 1);
    }

    private int LCA(TreeNode node, int level){
        if(node == null) return 0;
        
        int leftCount = LCS(node.left, level + 1);
        int rightCount = LCS(node.right, level + 1);
        int sum = leftCount + rightCount;
        if(level == depth) sum++;
        if(sum == count){
            res = node;
            return sum + 1;
        } 

        return sum; 
    }
}
```