## 94. Binary Tree Inorder Traversal
### follow up: Recursive solution is trivial, could you do it iteratively?
- 借用stack一直向左结点迭代直到将最左端叶子结点推入栈
- 将最左端叶子结点推出，添加值到List，使用相同的方法迭代其右结点
- 退出外层循环的条件不只是stack为空，且要满足所有结点都已经迭代完成

```java
class Solution {
    //follow up traverse iteratively
    //time complexity O(n) | space complexity O(n)    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root.left;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
```