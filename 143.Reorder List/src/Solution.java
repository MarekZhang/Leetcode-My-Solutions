/**
 * 143. Reorder List
Medium

1804

111

Add to List

Share
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        //reverse the second LinkedList
        newHead = reverse(newHead);
        ListNode p = head;
        ListNode q = newHead;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        //if the number of nodes is odd, the number of nodes of first part will be one more that the second
        while(q!=null){
            cur.next = p;
            p = p.next;
            cur=cur.next;
            cur.next = q;
            cur = cur.next;
            q= q.next;
            cur.next = null;
        }
        if(p!=null)
            cur.next = p;
        
        head = dummyHead.next;

    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){
        int[] arr = {1,2};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        new Solution().reorderList(head);
        NodeUtil.printList(head);
    }
}