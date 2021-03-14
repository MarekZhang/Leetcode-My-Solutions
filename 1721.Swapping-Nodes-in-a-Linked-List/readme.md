# 1721. Swapping Nodes in a Linked List

![1721%20Swapping%20Nodes%20in%20a%20Linked%20List%200102efe4c9644353845bfdeb752fd65a/Untitled.png](1721%20Swapping%20Nodes%20in%20a%20Linked%20List%200102efe4c9644353845bfdeb752fd65a/Untitled.png)

### Solution

- we can find the two nodes that we want to swap, and swapping the value of the node
- Follow up: what if we cannot modify the value of the node
    - we can break the list into nodes, and store the nodes in an array
    - we then re-assemble the list

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // time complexity O(N) || space complexity O(1)
  public ListNode swapNodes(ListNode head, int k) {
    if(head.next == null) return head;
    List<ListNode> list = new ArrayList<>();
    ListNode cur, nex;
    cur = nex = head;

    // break linkedList into an array of nodes
    while(cur != null){
      list.add(cur);
      nex = cur.next;
      cur.next = null;
      cur = nex;
    }

    // reassemble linked list
    int len = list.size();
    if(k == len - k + 1)
      return noSwapping(list);
    else
      return swapping(list, k);
  }

  private ListNode noSwapping(List<ListNode> list){
    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;
    for(ListNode node : list){
      cur.next = node;
      cur = cur.next;
    }

    return dummyHead.next;
  }

  private ListNode swapping(List<ListNode> list, int k) {
    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;
    int len = list.size();
    for(int i = 0; i < len; i++){
      if(i == k - 1){
        cur.next = list.get(len - k);
      }else if(i == len - k){
        cur.next = list.get(k - 1);
      }else{
        cur.next = list.get(i);
      }
      cur = cur.next;
    }

    return dummyHead.next;
  }
}
```