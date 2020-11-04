/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        //mapping each existing node with an newly created node
        Map<Node, Node> map = new HashMap<>();
        queue.addFirst(node);
        map.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node temptNode = queue.removeFirst();
            List<Node> neighborsList = temptNode.neighbors;
            Node copyNode = map.get(temptNode);
            for(Node no : neighborsList){
                if(!map.containsKey(no)){
                    map.put(no, new Node(no.val));
                    queue.addLast(no);
                }
                copyNode.neighbors.add(map.get(no));
            }    

        }
        return map.get(node);
    }
}