/*
133. Clone Graph
Medium

2104

1447

Add to List

Share
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
*/

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
    // time complexity O(N * MaxneiborsSize) || space complexity O(N)
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        //mapping each existing node with an newly created node
        Map<Node, Node> map = new HashMap<>();
        Set<Node> status = new HashSet<>();
        queue.addFirst(node);

        while(!queue.isEmpty()){
            Node temptNode = queue.removeFirst();
            if(!status.contains(temptNode)){
                status.add(temptNode);
                List<Node> neighborsList = temptNode.neighbors;
                if(!map.containsKey(temptNode))
                    map.put(temptNode, new Node(temptNode.val));
                for(Node no : neighborsList){
                    if(!map.containsKey(no))
                        map.put(no, new Node(no.val));
                    if(!status.contains(no))
                        queue.addLast(no);
                }
                Node copyNode = map.get(temptNode);
                for(Node no : neighborsList)
                    copyNode.neighbors.add(map.get(no));

            }
        }
        return map.get(node);
    }
}