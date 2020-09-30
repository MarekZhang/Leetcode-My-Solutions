/**
 * 138. Copy List with Random Pointer
Medium

3842

718

Add to List

Share
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        Node dummyHead = new Node(-1);
        Node curCopy = dummyHead;
        cur = head;
        while(cur != null){
            curCopy.next = map.get(cur);
            curCopy.next.random = map.get(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }

        return dummyHead.next;
    }
}