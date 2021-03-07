# 237. Delete Node in a Linked List

![237%20Delete%20Node%20in%20a%20Linked%20List%20e3e0ad804c6d4ad0abad3bb452266499/Untitled.png](237%20Delete%20Node%20in%20a%20Linked%20List%20e3e0ad804c6d4ad0abad3bb452266499/Untitled.png)

### Solution

- revise the val of the give node
- delete next node

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  // time complexity O(1) || space complexity O(1)
  public void deleteNode(ListNode node) {
    // copy the val of next node
    node.val = node.next.val;
    // delete next node
    node.next = node.next.next;
  }
}
```