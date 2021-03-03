# 19. Remove Nth Node From End of List

![19%20Remove%20Nth%20Node%20From%20End%20of%20List%205934347a2916434ca75cbeef6d034365/Untitled.png](19%20Remove%20Nth%20Node%20From%20End%20of%20List%205934347a2916434ca75cbeef6d034365/Untitled.png)

### Solution

- use two pointers

```java
class Solution {
    //time complexity O(N) || space complexity O(1)
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    ListNode prev, cur;
    prev = cur = dummyhead;
    while(n > 0){
      cur = cur.next;
      n--;
    }

    // find the prev node of the target node
    while(cur.next != null){
      prev = prev.next;
      cur = cur.next;
    }

    prev.next = prev.next.next;

    return dummyhead.next;
  }
}
```
