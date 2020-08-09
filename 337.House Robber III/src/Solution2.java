class Solution2 {
    public int rob(TreeNode root) {

        int[] res = robBS(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robBS(TreeNode node){
        int[] res = new int[2];
        if(node==null)
            return res;

        int[] leftNode = robBS(node.left);
        int[] rightNode = robBS(node.right);
        res[0] = leftNode[1] + rightNode[1];
        res[1] = Math.max(res[0], node.val + leftNode[0] + rightNode[0]);

        return res;
    }

}