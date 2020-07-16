import java.util.*;

class Solution2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        list.add(root.val);
        if(root.left!=null)
            preorderTraversal(root.left);
        if(root.right!=null)
            preorderTraversal(root.right);
        
        return list;
    }
}