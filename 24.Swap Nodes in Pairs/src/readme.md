# 24. Swap Nodes in Pairs

![24%20Swap%20Nodes%20in%20Pairs%20b882f54fcdad4b77b2e7f84a4f60b6d9/Untitled.png](24%20Swap%20Nodes%20in%20Pairs%20b882f54fcdad4b77b2e7f84a4f60b6d9/Untitled.png)

### Solution

- 使用recursion，思想类似于dfs，先递归到底，找到最后一对pair。将它们两个交换，并返回新的head给上一级调用。随着调用栈压入函数的陆续出栈，顺利将所有pair nodes交换
- 最开始我想使用divide and conquer,但对于这个问题来说是不合适的，因为pair是两两一对的，divide会出现很多奇数拆分pair的情况，所有不适用于此问题

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        if(head.next!=null){
            ListNode tempt = head.next.next;
            ListNode nex = head.next;
            nex.next = head;
            head.next = swapPairs(tempt);
            return nex;
        }
        
        return head;
    }
}
```