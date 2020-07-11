/**404. Sum of Left Leaves
Easy

1144

124

Add to List

Share
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

class Solution {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        calSum(root);

        return sum;
    }

    private void calSum(TreeNode root){
        if(root == null)
            return;
        TreeNode leftNode = root.left;
        if(leftNode != null){
            if(leftNode.left == null && leftNode.right == null)
                sum += leftNode.val;
            else
                sumOfLeftLeaves(root.left);
        }

        calSum(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.right = new TreeNode(7);

        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}