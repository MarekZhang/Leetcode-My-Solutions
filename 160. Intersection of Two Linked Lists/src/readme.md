# 160. Intersection of Two Linked Lists

![160%20Intersection%20of%20Two%20Linked%20Lists%2046e3471e184c4eb2b325cd8b1b9f8e99/Untitled.png](160%20Intersection%20of%20Two%20Linked%20Lists%2046e3471e184c4eb2b325cd8b1b9f8e99/Untitled.png)

### Solution

- calculate the length of linked list A and B;
- trim the longer list;
- traverse the two lists simultaneously;

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
//time complexity O(N) || space complexity 
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // count the length of linked list A and linked list B
    if(headA == null || headB == null) return null;

    int lenA, lenB;
    lenA = lenB = 0;
    ListNode curA = headA, curB = headB;
    while(curA != null){
      curA = curA.next;
      lenA++;
    }

    while(curB != null){
      curB = curB.next;
      lenB++;
    }

    // trim the longer list and traverse the two lists simultaneously
    curA = headA;
    curB = headB;
    if(lenA > lenB){
      int offset = lenA - lenB;
      while(offset > 0){
        curA = curA.next;
        offset--;
      }
    }else if(lenB > lenA){
      int offset = lenB - lenA;
      while(offset > 0){
        curB = curB.next;
        offset--;
      }
    }

    while(curA != null && curB != null){
      if(curA == curB) return curA;
      curA = curA.next;
      curB = curB.next;
    }

    return null;
  }
}
```