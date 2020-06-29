import java.util.*;

public class Solution2 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return res;
        dfs(root, 0);
        return res;
        
    }

    private void dfs(TreeNode node, int layer){
        if(res.size() <= layer){
            //先用0占位
            res.add(layer, 0);
        }
        res.set(layer, node.val);
        if(node.left != null)
            dfs(node.left, layer + 1);
        if(node.right != null)
            dfs(node.right, layer + 1);
    }
    
}