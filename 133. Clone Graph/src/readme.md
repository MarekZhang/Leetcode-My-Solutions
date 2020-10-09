## 133. Clone Graph
- 思路同[138. Copy List with Random Pointer](https://github.com/MarekZhang/Leetcode-My-Solutions/tree/master/138.%20Copy%20List%20with%20Random%20Pointer)由于需要deep copy，我们可以遍历每一个结点并且new一个新结点并且以<key, value>的形式保存在一个HashMap中。然后再组合。
- 使用一个HashSet来记录已经遍历过的结点。避免undirected graph(bi-direction edge)所造成的重复遍历
  
```java
class Solution {
    // time complexity O(N * MaxneiborsSize) || space complexity O(N)
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        LinkedList<Node> queue = new LinkedList<>();
        //mapping each existing node with an newly created node
        Map<Node, Node> map = new HashMap<>();
        //record if the Node has been retrived
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
```