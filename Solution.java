/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max, min;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        traverse(root, 0, 0, map);
        
    }

    private void traverse(TreeNode node, int x, int y, Map<Integer, PriorityQueue<int[]>> map){
        if(node == null) return;
        traverse(node.left, x - 1, y - 1, map);
        map.putIfAbsent(x, new PriorityQueue<>(new NodeComparator()));
        map.get(x).put(new int[]{y, node.val});
        max = Integer.max(max, x);
        min = Integer.min(min, x);
        traverse(node.right, x + 1, y - 1, map);
    }

    private class NodeComparator implements Comparator<int[]>{
        //arr[0] represents y, arr[1] represents value
        public int compare(int[] arr1, int[] arr2) {
            if(arr1[0] > arr2[1]) return 1;
            else if(arr1[0] < arr2[1]) return -1;
            else return arr1[1] - arr2[1];
        }
    }
}

