/**
 * 450. Delete Node in a BST
Medium

1756

83

Add to List

Share
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        //when root is the Node to be deleted

        if(root.val > key)
            root.left = deleteNode(root.left, key);

        if(root.val < key)
            root.right = deleteNode(root.right, key);

        if(root.val == key){
            if(root.right == null){
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            if(root.left==null){
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }

            //find the biggest value in its left nodes or the maximum value in the right nodes(in this question we select the first one)
            //newRoot is about to be deleted
            TreeNode newRoot = new TreeNode(maximumNode(root.left).val);
            newRoot.left = removeMaximum(root.left);
            newRoot.right = root.right;
            root.left = root.right = null;

            return newRoot;
        }
        
        return root;
    }

    private TreeNode maximumNode(TreeNode node){
        if(node == null)
            return null;
        while(node.right != null)
            node = node.right;

        return node;
    }

    private TreeNode removeMaximum(TreeNode node){
        if(node.right == null){
            TreeNode leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMaximum(node.right);
        return node;
    }
}