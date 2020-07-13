/**
 * 129. Sum Root to Leaf Numbers
Medium

1495

42

Add to List

Share
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

import java.util.*;

class Solution {
  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if(root == null)
      return sum;

      List<String> operandsList = dfs(root);
      for(String str: operandsList)
        sum += Integer.parseInt(str);

      return sum;
  }

  private List<String> dfs(TreeNode root) {
    List<String> operandsList = new ArrayList<>();
    if(root == null)
      return operandsList;
    if(root.left == null && root.right == null)
      operandsList.add(Integer.toString(root.val));

    List<String> leftOperands = dfs(root.left);
    for(int i = 0; i < leftOperands.size(); i++)
      operandsList.add(Integer.toString(root.val) + leftOperands.get(i));
    

    List<String> rightOperands = dfs(root.right);
    for(int i = 0; i < rightOperands.size(); i++)
      operandsList.add(Integer.toString(root.val) + rightOperands.get(i));

    return operandsList;
  }
}