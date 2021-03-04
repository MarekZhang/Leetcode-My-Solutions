# 86. Partition List

![86%20Partition%20List%20b5180e78ab8940bcb5b1cdd6febfe243/Untitled.png](86%20Partition%20List%20b5180e78ab8940bcb5b1cdd6febfe243/Untitled.png)

### Solution

1. use two dummy head to separate nodes into two groups( less than x, greater or equal)
2. use a queue to store nodes greater or equals x

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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller, greater, cur1, cur2;
        smaller = new ListNode(-1);
        greater = new ListNode(-1);
        cur1 = smaller;
        cur2 = greater;
        
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
                // prevent generating loop
                head = head.next;
                cur1.next = null;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
                // prevent generating loop
                head = head.next;
                cur2.next = null;
            }
            
        }
        if(greater.next != null)
            cur1.next = greater.next;
        
        return smaller.next;
    }
}
```

```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        LinkedList<ListNode> queue = new LinkedList<ListNode>();

        while(head != null){
            if(head.val < x){
                cur.next = head;
                cur = cur.next;
                // cur.next = null;
            }else{
                queue.addLast(head);
            }

            head = head.next;
        }

        while(!queue.isEmpty()){
            cur.next = queue.removeFirst();
            cur = cur.next;
            // cur.next = null;
        }

        cur.next = null;

        return dummyHead.next;
    }
}
```