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

public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = p;
        for(int i = 0; i <= n; i++){
            q = q.next;
        }

        //find the prev node of the Node to be removed
        while(q!=null){
            p = p.next;
            q = q.next;
        }

        ListNode nex = p.next.next;
        p.next = nex;

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;
    }
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().removeNthFromEnd(head, 5);
        NodeUtil.printList(head);
    }
}