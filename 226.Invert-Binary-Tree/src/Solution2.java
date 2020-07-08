public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode tempt = root.left;
        root.left = root.right;
        root.right = tempt;

        invertTree(root.left);
        invertTree(root.right);

        return root;
        
    }
}