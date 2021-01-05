# 863. All Nodes Distance K in Binary Tree

![863%20All%20Nodes%20Distance%20K%20in%20Binary%20Tree%2058d379de882d4f1186ee8d30e8eedd82/Untitled.png](863%20All%20Nodes%20Distance%20K%20in%20Binary%20Tree%2058d379de882d4f1186ee8d30e8eedd82/Untitled.png)

### Solution

- convert binary tree to undirected graph + bfs

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[501];

        //bfs
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{target.val, 0});
        visited[target.val] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.removeFirst();
            int nodeVal = arr[0];
            int k = arr[1];
            if(k == K) res.add(nodeVal);
            else if(k < K){
                for(int node : graph.get(nodeVal)){
                    if(!visited[node]){
                        visited[node] = true;
                        queue.addLast(new int[]{node, k + 1});
                    }
                }
            }
        }

        return res;
    }

    private void buildGraph(TreeNode root, Map<Integer, ArrayList<Integer>> graph) {
        if(root == null) return;
        int rootVal = root.val;
        graph.putIfAbsent(rootVal, new ArrayList<>());

        if(root.left != null){
            int leftVal = root.left.val;
            graph.putIfAbsent(leftVal, new ArrayList<>());
            graph.get(rootVal).add(leftVal);
            graph.get(leftVal).add(rootVal);
            buildGraph(root.left, graph);
        }
        if(root.right != null){
            int rightVal = root.right.val;
            graph.putIfAbsent(rightVal, new ArrayList<>());
            graph.get(rootVal).add(rightVal);
            graph.get(rightVal).add(rootVal);
            buildGraph(root.right, graph);
        }
    }
}
```
