/**
 * 19. Remove Nth Node From End of List
Medium

3192

229

Add to List

Share
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode tempt = head;
        while(tempt.next!=null){
            count++;
            tempt = tempt.next;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for(int i = 0; i < count - n; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode nex = cur.next;
        pre.next = nex;
        cur.next = null;
        cur = null;

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().removeNthFromEnd(head, 4);
        NodeUtil.printList(head);
    }
}