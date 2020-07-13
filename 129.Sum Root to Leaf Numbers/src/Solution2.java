public class Solution2 {
    private Integer res = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int tnum){
        tnum = tnum * 10 + root.val;
        if(root.left == null && root.right == null)
            res += tnum;
        else{
            if(root.left != null)
                dfs(root.left, tnum);
            if(root.right != null)
                dfs(root.right, tnum);
        }
    }
}