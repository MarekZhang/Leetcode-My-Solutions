## Solution 
- 这个递归的解法和反转二叉树基本相同，可以先扭转当前结点和他的下一个结点，然后在与递归调用的函数结果相连接

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
    //time complexity O(N) || space complexity O(N) -- stack space for recursion
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //reverse the order of current node and its next node, only if the next node is not null
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