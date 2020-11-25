/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        StringBuilder builder = new StringBuilder();
        inOrder(root, builder);
        
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String nodes[] = data.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for(String str : nodes)
            queue.addLast(str);
        return buildTree(queue);
    }
    
    private void inOrder(TreeNode node, StringBuilder builder){
        if(node == null){
            builder.append("null,");
            return;
        }
        builder.append(node.val + ",");
        inOrder(node.left, builder);
        inOrder(node.right, builder);
    }
    
    private TreeNode buildTree(LinkedList<String> queue){
        String str = queue.removeFirst();
        if(str.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        
        return node;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));