/**
 * 24. Swap Nodes in Pairs
Medium

2178

167

Add to List

Share
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

 public class Solution{
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        
        //先判断后赋值，防止调用 Null.next
        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }
 }