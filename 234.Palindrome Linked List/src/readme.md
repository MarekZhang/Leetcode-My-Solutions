# 234. Palindrome Linked List

![234%20Palindrome%20Linked%20List%20de305d4aa5fe49969e09c5ff0182a475/Untitled.png](234%20Palindrome%20Linked%20List%20de305d4aa5fe49969e09c5ff0182a475/Untitled.png)

### Solution

- break the linked list at the middle node
- reverse the second linked list
- traverse the two linked list simultaneously

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
  public boolean isPalindrome(ListNode head) {
    if(head.next == null) return true;
    // fast, slow pointer find the middle node
    ListNode fast, slow;
    slow = head;
    fast = slow.next;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    // break the linked list into two parts and reverse the second part
    ListNode newHead = slow.next;
    slow.next = null;
    newHead = reserve(newHead);

    // traverse two linked list simultaneously
    while(newHead != null){
      if(head.val != newHead.val) return false;
      newHead = newHead.next;
      head = head.next;
    }

    return true;
  }

  private ListNode reserve(ListNode node){
    if(node.next == null) return node;

    ListNode cur, nex, prev;
    prev = null;
    cur = node;
    nex = cur.next;
    while(true){
      cur.next = prev;
      prev = cur;
      cur = nex;
      if(cur == null) break;
      nex = nex.next;
    }

    return prev;
  }
}
```