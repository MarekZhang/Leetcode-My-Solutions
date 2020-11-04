## 133. Clone Graph
- 思路同[138. Copy List with Random Pointer](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/138.%20Copy%20List%20with%20Random%20Pointer)由于需要deep copy，我们可以遍历每一个结点并且new一个新结点并且以<key, value>的形式保存在一个HashMap中。然后再组合。
  
```java
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
```