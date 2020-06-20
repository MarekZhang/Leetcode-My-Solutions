/**25. Reverse Nodes in k-Group
Hard

2102

357

Add to List

Share
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while(pre!=null && pre.next!=null){
            ListNode end = pre;
            int i = 0;
            for(i = 0; i < k; i++){
                end = end.next;
                if(end == null)
                    break;
            }
            if(i!=k)
                break;

            ListNode nex = end.next;
            ListNode rhead = reverse(pre.next, end);
            ListNode tail = pre.next;

            pre.next = rhead;
            tail.next = nex;

            pre=tail;
        }

        ListNode result = dummyHead.next;
        dummyHead = null;

        return result;

    }

    private ListNode reverse(ListNode head, ListNode end){
        if(head == end)
            return head;
        ListNode rhead = reverse(head.next, end);
        head.next.next =head;

        return rhead;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = NodeUtil.createList(arr, arr.length);
        NodeUtil.printList(head);
        head = new Solution().reverseKGroup(head, 4);
        NodeUtil.printList(head);
    }
}