class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prevNode = node.prev;
        DLinkedNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    private void addToTail(DLinkedNode node){
        DLinkedNode prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }
    /**dummy head and dummy tail */
    private DLinkedNode head;
    private DLinkedNode tail;
    private int capacity;
    private HashMap<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        DLinkedNode node = map.get(key);
        removeNode(node);
        addToTail(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addToTail(node);
            map.put(key, node);

            return;
        }

        if(capacity == map.size()) {
            DLinkedNode node = head.next;
            removeNode(node);
            map.remove(node.key);
        }

        DLinkedNode node = new DLinkedNode(key, value);
        addToTail(node);
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */