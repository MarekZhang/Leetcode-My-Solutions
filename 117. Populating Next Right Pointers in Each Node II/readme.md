# 117. Populating Next Right Pointers in Each Node II

![Untitled](117%20Populating%20Next%20Right%20Pointers%20in%20Each%20Node%20II%20f59f35fb29da45b8b5caa0a6cfd68bf1/Untitled.png)

- pitfall → connect right part first

connect left would be wrong, (0) cannot connect with right (8)

![Untitled](117%20Populating%20Next%20Right%20Pointers%20in%20Each%20Node%20II%20f59f35fb29da45b8b5caa0a6cfd68bf1/Untitled%201.png)

connect right first

![Untitled](117%20Populating%20Next%20Right%20Pointers%20in%20Each%20Node%20II%20f59f35fb29da45b8b5caa0a6cfd68bf1/Untitled%202.png)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        if(root.left != null) {
            if(root.right != null) root.left.next = root.right;
            else root.left.next = findNearest(root.next);
        }
        
        if(root.right != null) root.right.next = findNearest(root.next);
        
        connect(root.left);
        connect(root.right);
        
        return root;
        
    }
    
    private Node findNearest(Node node) {
        if(node == null) return null;
        if(node.left != null) return node.left;
        if(node.right != null) return node.right;
       
        return findNearest(node.next);
    }
}
```

```java
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node cur = root;
        Node dummy = new Node(-1);
        Node p = dummy;
        
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    p.next = cur.left;
                    p = p.next;
                }
                if(cur.right != null){
                    p.next = cur.right;
                    p = p.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
            dummy = new Node(-1);
            p = dummy;
        }
        return root;
    }
}
```