/**
 * 437. Path Sum III
Easy

3445

294

Add to List

Share
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

class Solution {
    //number of paths include path root inclusive and path that root exclusive
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        //find the number of paths root inclusive;
        int res = findPath(root, sum);
        //find the number of paths root exclusive;
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(root.val == sum)
            res += 1;
        //as the node val could be negative value, the calculation of sum should be dived into deeper layer
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);

        return res;
    }
}