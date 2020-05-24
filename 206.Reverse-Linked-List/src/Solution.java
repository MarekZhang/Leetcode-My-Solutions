/**206. Reverse Linked List
Easy

4124

84

Add to List

Share
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL */
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

    private class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = head.next;

        while(true){ 
            cur.next = pre;
            pre = cur;
            cur = nex;
            if(cur == null)
                break;
            nex = nex.next;
        }
        return pre;

    }
}