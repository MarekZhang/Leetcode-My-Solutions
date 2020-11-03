### Solution
- 使用dfs，当消除了leaf node中val 为0的结点后需要确认当前的node是否成为了新的leaf node 且 val为0
- Space complexity 应该是O(H), H为树的最大深度，因为dfs算法遍历到底，之后会出栈然后入栈新的分支。栈空间最大就是树的最大深度
![](dfs.png)