/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            res.add(new ArrayList<>());
            int idx = res.size() -1;
            int sz = queue.size();
            for(int i = 0; i < sz; i++){
                Node node = queue.removeFirst();
                res.get(idx).add(node.val);
                for(Node child : node.children)
                    queue.addLast(child);
            }
        }
        
        return res;
    }
}